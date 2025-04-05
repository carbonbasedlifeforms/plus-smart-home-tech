package ru.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.practicum.enums.HubEventType;
import ru.practicum.model.hub.HubEvent;
import ru.practicum.model.hub.ScenarioRemovedEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.ScenarioRemovedEventAvro;

@Component
public class ScenarioRemovedEventHandler extends BaseHubEventHandler<ScenarioRemovedEventAvro> {
    public ScenarioRemovedEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    public ScenarioRemovedEventAvro toAvro(HubEvent hubEvent) {
        return ScenarioRemovedEventAvro.newBuilder()
                .setName(((ScenarioRemovedEvent) hubEvent).getName())
                .build();
    }

    @Override
    public HubEventType getEventType() {
        return HubEventType.SCENARIO_REMOVED;
    }
}
