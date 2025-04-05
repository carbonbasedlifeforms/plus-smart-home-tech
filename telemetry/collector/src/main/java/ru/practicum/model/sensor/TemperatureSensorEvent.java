package ru.practicum.model.sensor;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.practicum.enums.SensorEventType;

@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemperatureSensorEvent extends SensorEvent {
    @NotNull
    int temperatureC;

    @NotNull
    int temperatureF;

    @Override
    public SensorEventType getSensorType() {
        return SensorEventType.TEMPERATURE_SENSOR_EVENT;
    }
}
