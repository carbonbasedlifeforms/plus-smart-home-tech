package ru.yandex.practicum.dto.warehouse;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
public class AssemblyProductsForOrderRequest {
    @NotNull
    private Map<UUID, Long> products;

    @NotNull
    private UUID orderId;
}
