package ru.yandex.practicum.exceptions;

public class ServiceFallBackException extends RuntimeException {
    public ServiceFallBackException(String message) {
        super(message);
    }
}
