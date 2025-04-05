package ru.practicum.model.hub;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.practicum.enums.DeviceActionType;

@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class DeviceAction {
    String sensorId;

    DeviceActionType type;

    int value;
}
