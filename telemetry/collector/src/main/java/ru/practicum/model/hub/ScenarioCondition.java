package ru.practicum.model.hub;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.practicum.enums.ScenarioConditionOperation;
import ru.practicum.enums.ScenarioConditionType;

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
