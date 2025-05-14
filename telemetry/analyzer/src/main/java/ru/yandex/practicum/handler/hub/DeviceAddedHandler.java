package ru.yandex.practicum.handler.hub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.kafka.telemetry.event.DeviceAddedEventAvro;
import ru.yandex.practicum.kafka.telemetry.event.HubEventAvro;
import ru.yandex.practicum.model.Sensor;
import ru.yandex.practicum.repository.SensorRepository;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeviceAddedHandler implements HubEventHandler {
    private final SensorRepository sensorRepository;

    @Override
    public void handleEvent(HubEventAvro event) {
        DeviceAddedEventAvro deviceAddedEventAvro = (DeviceAddedEventAvro) event.getPayload();
        log.info("Device with id: {} for hub id: {}  added ", deviceAddedEventAvro.getId(), event.getHubId());
        if (!sensorRepository.existsByIdInAndHubId(List.of(deviceAddedEventAvro.getId()), event.getHubId())) {
            Sensor sensor = Sensor.builder()
                    .id(deviceAddedEventAvro.getId())
                    .hubId(event.getHubId())
                    .build();
            sensorRepository.save(sensor);
        }
    }

    @Override
    public String getEventType() {
        return DeviceAddedEventAvro.class.getSimpleName();
    }
}
