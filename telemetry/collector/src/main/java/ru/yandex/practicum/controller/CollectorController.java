package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.enums.HubEventType;
import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.model.hub.HubEvent;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.service.hub.HubEventHandler;
import ru.yandex.practicum.service.sensor.SensorEventHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/events")
public class CollectorController {
    private final Map<SensorEventType, SensorEventHandler> sensorHandlers;
    private final Map<HubEventType, HubEventHandler> hubHandlers;

    public CollectorController(List<SensorEventHandler> sensorHandlers, List<HubEventHandler> hubHandlers) {
        this.sensorHandlers = sensorHandlers.stream()
                .collect(Collectors.toMap(SensorEventHandler::getEventType, Function.identity()));
        this.hubHandlers = hubHandlers.stream()
                .collect(Collectors.toMap(HubEventHandler::getEventType, Function.identity()));
    }

    @PostMapping("/sensors")
    public void collectSensorEvent(@Valid @RequestBody SensorEvent event) {
        if (sensorHandlers.containsKey(event.getSensorType())) {
            log.info("Handling sensor event: {}", event);
            sensorHandlers.get(event.getSensorType()).handleEvent(event);
        } else {
            log.warn("Unknown sensor event type: {}", event.getSensorType());
        }
    }

    @PostMapping("/hubs")
    public void collectHubEvent(@Valid @RequestBody HubEvent event) {
        if (hubHandlers.containsKey(event.getHubEventType())) {
            log.info("Handling hub event: {}", event);
            hubHandlers.get(event.getHubEventType()).handleEvent(event);
        } else {
            log.warn("Unknown hub event type: {}", event.getHubEventType());
        }
    }
}
