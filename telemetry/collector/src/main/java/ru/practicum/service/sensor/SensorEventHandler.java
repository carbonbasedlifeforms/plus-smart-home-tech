package ru.practicum.service.sensor;

import ru.practicum.enums.SensorEventType;
import ru.practicum.model.sensor.SensorEvent;

public interface SensorEventHandler {
    SensorEventType getEventType();

    void handleEvent(SensorEvent sensorEvent);
}
