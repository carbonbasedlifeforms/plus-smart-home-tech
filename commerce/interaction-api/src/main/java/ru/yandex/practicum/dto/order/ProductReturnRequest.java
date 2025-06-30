package ru.yandex.practicum.dto.order;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductReturnRequest {
    private UUID orderId;

    @NotNull
    private Map<UUID, Long> products;
}
