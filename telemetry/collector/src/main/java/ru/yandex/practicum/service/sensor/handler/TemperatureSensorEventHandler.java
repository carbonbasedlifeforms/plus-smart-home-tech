package ru.yandex.practicum.service.sensor.handler;

import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.kafka.telemetry.event.TemperatureSensorAvro;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.model.sensor.TemperatureSensorEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

public class TemperatureSensorEventHandler extends BaseSensorEventHandler<TemperatureSensorAvro> {
    public TemperatureSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected TemperatureSensorAvro toAvro(SensorEvent sensorEvent) {
        TemperatureSensorEvent temperatureSensorEvent = (TemperatureSensorEvent) sensorEvent;
        return TemperatureSensorAvro.newBuilder()
                .setTemperatureC(temperatureSensorEvent.getTemperatureC())
                .setTemperatureF(temperatureSensorEvent.getTemperatureF())
                .build();
    }

    @Override
    public SensorEventType getEventType() {
        return SensorEventType.TEMPERATURE_SENSOR_EVENT;
    }
}
