package ru.yandex.practicum.model.hub;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import ru.yandex.practicum.enums.HubEventType;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScenarioAddedEvent extends HubEvent {
    @NotBlank
    @Length(min = 3)
    String name;

    @NotEmpty
    List<ScenarioCondition> conditions;

    @NotEmpty
    List<DeviceAction> actions;

    @Override
    public HubEventType getHubEventType() {
        return HubEventType.SCENARIO_ADDED;
    }
}
