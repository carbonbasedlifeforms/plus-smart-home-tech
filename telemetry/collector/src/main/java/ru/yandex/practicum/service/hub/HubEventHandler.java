package ru.yandex.practicum.service.hub;

import ru.yandex.practicum.grpc.telemetry.event.HubEventProto;

public interface HubEventHandler {
    HubEventProto.PayloadCase getEventType();

    void handleEvent(HubEventProto hubEvent);
}
