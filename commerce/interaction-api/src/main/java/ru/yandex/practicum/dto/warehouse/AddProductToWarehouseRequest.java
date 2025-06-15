package ru.yandex.practicum.dto.warehouse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class AddProductToWarehouseRequest {
    @NotNull
    private UUID productId;

    @Positive
    private Long quantity;
}
