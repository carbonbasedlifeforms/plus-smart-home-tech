package ru.yandex.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.kafka.telemetry.event.SwitchSensorAvro;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.model.sensor.SwitchSensorEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

@Component
public class SwitchSensorEventHandler extends BaseSensorEventHandler<SwitchSensorAvro> {
    public SwitchSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected SwitchSensorAvro toAvro(SensorEvent sensorEvent) {
        SwitchSensorEvent switchSensorEvent = (SwitchSensorEvent) sensorEvent;
        return SwitchSensorAvro.newBuilder()
                .setState(switchSensorEvent.isState())
                .build();
    }

    @Override
    public SensorEventType getEventType() {
        return SensorEventType.SWITCH_SENSOR_EVENT;
    }
}
