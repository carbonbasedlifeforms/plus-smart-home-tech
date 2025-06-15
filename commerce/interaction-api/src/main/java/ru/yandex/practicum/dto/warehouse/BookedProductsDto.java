package ru.yandex.practicum.dto.warehouse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BookedProductsDto {
    @Positive
    double deliveryWeight;

    @Positive
    double deliveryVolume;

    @NotNull
    boolean fragile;
}
