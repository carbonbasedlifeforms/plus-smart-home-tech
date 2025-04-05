package ru.practicum.service.sensor.handler;

import ru.practicum.enums.SensorEventType;
import ru.practicum.model.sensor.SensorEvent;
import ru.practicum.model.sensor.TemperatureSensorEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.TemperatureSensorAvro;

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
