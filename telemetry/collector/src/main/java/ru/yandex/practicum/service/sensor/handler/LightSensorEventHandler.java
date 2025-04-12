package ru.yandex.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.grpc.telemetry.event.LightSensorProto;
import ru.yandex.practicum.grpc.telemetry.event.SensorEventProto;
import ru.yandex.practicum.kafka.telemetry.event.LightSensorAvro;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

@Component
public class LightSensorEventHandler extends BaseSensorEventHandler<LightSensorAvro> {
    public LightSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected LightSensorAvro toAvro(SensorEventProto sensorEvent) {
        LightSensorProto lightSensorEvent = sensorEvent.getLightSensorEvent();
        return LightSensorAvro.newBuilder()
                .setLinkQuality(lightSensorEvent.getLinkQuality())
                .setLuminosity(lightSensorEvent.getLuminosity())
                .build();
    }

    @Override
    public SensorEventProto.PayloadCase getEventType() {
        return SensorEventProto.PayloadCase.LIGHT_SENSOR_EVENT;
    }
}
