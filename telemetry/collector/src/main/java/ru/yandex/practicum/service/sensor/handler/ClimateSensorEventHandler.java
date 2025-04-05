package ru.yandex.practicum.service.sensor.handler;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.kafka.telemetry.event.ClimateSensorAvro;
import ru.yandex.practicum.model.sensor.ClimateSensorEvent;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

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
