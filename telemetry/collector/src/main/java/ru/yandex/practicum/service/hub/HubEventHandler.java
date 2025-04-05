package ru.yandex.practicum.service.hub;

import ru.yandex.practicum.enums.HubEventType;
import ru.yandex.practicum.model.hub.HubEvent;

public interface HubEventHandler {
    HubEventType getEventType();

    void handleEvent(HubEvent hubEvent);
}
