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
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SwitchSensorEvent extends SensorEvent{
    @NotNull
    boolean state;

    @Override
    public SensorEventType getSensorType() {
        return SensorEventType.SWITCH_SENSOR_EVENT;
    }
}
