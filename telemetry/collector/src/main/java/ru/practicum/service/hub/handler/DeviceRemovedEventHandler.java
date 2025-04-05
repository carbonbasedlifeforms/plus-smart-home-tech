package ru.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.practicum.enums.HubEventType;
import ru.practicum.model.hub.DeviceRemovedEvent;
import ru.practicum.model.hub.HubEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.DeviceRemovedEventAvro;

@Component
public class DeviceRemovedEventHandler extends BaseHubEventHandler<DeviceRemovedEventAvro> {
    public DeviceRemovedEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    public DeviceRemovedEventAvro toAvro(HubEvent hubEvent) {
        return DeviceRemovedEventAvro.newBuilder()
                .setId(((DeviceRemovedEvent) hubEvent).getId())
                .build();
    }

    @Override
    public HubEventType getEventType() {
        return HubEventType.DEVICE_REMOVED;
    }
}
