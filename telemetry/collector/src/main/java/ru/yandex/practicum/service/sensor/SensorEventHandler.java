package ru.yandex.practicum.service.sensor;

import ru.yandex.practicum.grpc.telemetry.event.SensorEventProto;

public interface SensorEventHandler {
    SensorEventProto.PayloadCase getEventType();

    void handleEvent(SensorEventProto sensorEvent);
}
