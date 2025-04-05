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
public class MotionSensorEvent extends SensorEvent{
    @NotNull
    int linkQuality;

    @NotNull
    boolean motion;

    @NotNull
    int voltage;

    @Override
    public SensorEventType getSensorType() {
        return SensorEventType.MOTION_SENSOR_EVENT;
    }
}
