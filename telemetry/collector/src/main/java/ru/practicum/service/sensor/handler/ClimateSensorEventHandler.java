package ru.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.practicum.enums.SensorEventType;
import ru.practicum.model.sensor.ClimateSensorEvent;
import ru.practicum.model.sensor.SensorEvent;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.ClimateSensorAvro;

@Component
public class ClimateSensorEventHandler extends BaseSensorEventHandler<ClimateSensorAvro>{
    public ClimateSensorEventHandler(CollectorKafkaProducer producer) {
        super(producer);
    }

    @Override
    protected ClimateSensorAvro toAvro(SensorEvent sensorEvent) {
        ClimateSensorEvent climateSensorEvent = (ClimateSensorEvent) sensorEvent;
        return ClimateSensorAvro.newBuilder()
                .setTemperatureC(climateSensorEvent.getTemperatureC())
                .setHumidity(climateSensorEvent.getHumidity())
                .setCo2Level(climateSensorEvent.getCo2Level())
                .build();
    }

    @Override
    public SensorEventType getEventType() {
        return SensorEventType.CLIMATE_SENSOR_EVENT;
    }
}
