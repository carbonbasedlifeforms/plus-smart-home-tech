package ru.yandex.practicum.exceptions;

public class SpecifiedProductAlreadyInWarehouseException extends RuntimeException{
    public SpecifiedProductAlreadyInWarehouseException(String message) {
        super(message);
    }
}
