package ru.yandex.practicum.model.sensor;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.enums.SensorEventType;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(callSuper = true)
public class ClimateSensorEvent extends SensorEvent {
    @NotNull
    int temperatureC;

    @NotNull
    int humidity;

    @NotNull
    int co2Level;

    @Override
    public SensorEventType getSensorType() {
        return SensorEventType.CLIMATE_SENSOR_EVENT;
    }
}

