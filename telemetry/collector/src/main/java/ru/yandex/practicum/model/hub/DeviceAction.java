package ru.yandex.practicum.model.hub;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.enums.DeviceActionType;

@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class DeviceAction {
    @NotNull
    String sensorId;

    @NotNull
    DeviceActionType type;

    int value;
}
