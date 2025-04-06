package ru.yandex.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.enums.HubEventType;
import ru.yandex.practicum.kafka.telemetry.event.*;
import ru.yandex.practicum.model.hub.DeviceAction;
import ru.yandex.practicum.model.hub.HubEvent;
import ru.yandex.practicum.model.hub.ScenarioAddedEvent;
import ru.yandex.practicum.model.hub.ScenarioCondition;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

@Component
public class ScenarioAddedEventHandler extends BaseHubEventHandler<ScenarioAddedEventAvro> {
    public ScenarioAddedEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    public ScenarioAddedEventAvro toAvro(HubEvent hubEvent) {
        ScenarioAddedEvent scenarioAddedEvent = (ScenarioAddedEvent) hubEvent;
        return ScenarioAddedEventAvro.newBuilder()
                .setName(scenarioAddedEvent.getName())
                .setActions(scenarioAddedEvent.getActions().stream()
                        .map(this::toDeviceActionAvro)
                        .toList())
                .setConditions(scenarioAddedEvent.getConditions().stream()
                        .map(this::toConditionAvro)
                        .toList())
                .build();
    }

    @Override
    public HubEventType getEventType() {
        return HubEventType.SCENARIO_ADDED;
    }

    private DeviceActionAvro toDeviceActionAvro(DeviceAction deviceAction) {
        return DeviceActionAvro.newBuilder()
                .setSensorId(deviceAction.getSensorId())
                .setValue(deviceAction.getValue())
                .setType(ActionTypeAvro.valueOf(deviceAction.getType().name()))
                .build();
    }

    private ScenarioConditionAvro toConditionAvro(ScenarioCondition scenarioCondition) {
        return ScenarioConditionAvro.newBuilder()
                .setSensorId(scenarioCondition.getSensorId())
                .setValue(scenarioCondition.getValue())
                .setType(ConditionTypeAvro.valueOf(scenarioCondition.getType().name()))
                .setOperation(ConditionOperationAvro.valueOf(scenarioCondition.getOperation().name()))
                .build();
    }
}
