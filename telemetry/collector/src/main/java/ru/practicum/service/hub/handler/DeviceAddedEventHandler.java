package ru.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.practicum.enums.HubEventType;
import ru.practicum.model.hub.DeviceAddedEvent;
import ru.practicum.model.hub.HubEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.DeviceAddedEventAvro;
import ru.yandex.practicum.kafka.telemetry.event.DeviceTypeAvro;

@Component
public class DeviceAddedEventHandler extends BaseHubEventHandler<DeviceAddedEventAvro> {
    public DeviceAddedEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    public DeviceAddedEventAvro toAvro(HubEvent hubEvent) {
        DeviceAddedEvent deviceAddedEvent = (DeviceAddedEvent) hubEvent;
        DeviceTypeAvro deviceTypeAvro = DeviceTypeAvro.valueOf(deviceAddedEvent.getDeviceType().name());

        return DeviceAddedEventAvro.newBuilder()
                .setId(deviceAddedEvent.getId())
                .setType(deviceTypeAvro)
                .build();
    }

    @Override
    public HubEventType getEventType() {
        return HubEventType.DEVICE_ADDED;
    }
}
