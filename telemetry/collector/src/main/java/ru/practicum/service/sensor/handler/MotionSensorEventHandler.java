package ru.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.practicum.enums.SensorEventType;
import ru.practicum.model.sensor.MotionSensorEvent;
import ru.practicum.model.sensor.SensorEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.MotionSensorAvro;

@Component
public class MotionSensorEventHandler extends BaseSensorEventHandler<MotionSensorAvro> {
    public MotionSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected MotionSensorAvro toAvro(SensorEvent sensorEvent) {
        MotionSensorEvent motionSensorEvent = (MotionSensorEvent) sensorEvent;
        return MotionSensorAvro.newBuilder()
                .setMotion(motionSensorEvent.isMotion())
                .setLinkQuality(motionSensorEvent.getLinkQuality())
                .setVoltage(motionSensorEvent.getVoltage())
                .build();
    }

    @Override
    public SensorEventType getEventType() {
        return SensorEventType.MOTION_SENSOR_EVENT;
    }
}
