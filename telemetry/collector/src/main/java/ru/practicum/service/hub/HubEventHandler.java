package ru.practicum.service.hub;

import ru.practicum.enums.HubEventType;
import ru.practicum.model.hub.HubEvent;

public interface HubEventHandler {
    HubEventType getEventType();

    void handleEvent(HubEvent hubEvent);
}
