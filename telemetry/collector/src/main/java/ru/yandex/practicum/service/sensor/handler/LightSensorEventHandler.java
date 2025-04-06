package ru.yandex.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.kafka.telemetry.event.LightSensorAvro;
import ru.yandex.practicum.model.sensor.LightSensorEvent;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

@Component
public class LightSensorEventHandler extends BaseSensorEventHandler<LightSensorAvro> {
    public LightSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected LightSensorAvro toAvro(SensorEvent sensorEvent) {
        LightSensorEvent lightSensorEvent = (LightSensorEvent) sensorEvent;
        return LightSensorAvro.newBuilder()
                .setLinkQuality(lightSensorEvent.getLinkQuality())
                .setLuminosity(lightSensorEvent.getLuminosity())
                .build();
    }

    @Override
    public SensorEventType getEventType() {
        return SensorEventType.LIGHT_SENSOR_EVENT;
    }
}
