package ru.yandex.practicum.model.hub;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.enums.ScenarioConditionOperation;
import ru.yandex.practicum.enums.ScenarioConditionType;

@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScenarioCondition {
    String sensorId;

    ScenarioConditionType type;

    ScenarioConditionOperation operation;

    int value;
}
