package ru.yandex.practicum.service.hub.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.grpc.telemetry.event.HubEventProto;
import ru.yandex.practicum.kafka.telemetry.event.DeviceRemovedEventAvro;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

@Component
public class DeviceRemovedEventHandler extends BaseHubEventHandler<DeviceRemovedEventAvro> {
    public DeviceRemovedEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    public DeviceRemovedEventAvro toAvro(HubEventProto hubEvent) {
        return DeviceRemovedEventAvro.newBuilder()
                .setId(hubEvent.getDeviceRemovedEvent().getId())
                .build();
    }

    @Override
    public HubEventProto.PayloadCase getEventType() {
        return HubEventProto.PayloadCase.DEVICE_REMOVED_EVENT;
    }
}
