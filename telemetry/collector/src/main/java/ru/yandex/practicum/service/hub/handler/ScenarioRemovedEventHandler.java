package ru.yandex.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.enums.HubEventType;
import ru.yandex.practicum.kafka.telemetry.event.ScenarioRemovedEventAvro;
import ru.yandex.practicum.model.hub.HubEvent;
import ru.yandex.practicum.model.hub.ScenarioRemovedEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

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
