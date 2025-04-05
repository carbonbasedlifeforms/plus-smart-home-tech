package ru.yandex.practicum.service.sensor;

import ru.yandex.practicum.enums.SensorEventType;
import ru.yandex.practicum.model.sensor.SensorEvent;

public interface SensorEventHandler {
    SensorEventType getEventType();

    void handleEvent(SensorEvent sensorEvent);
}
