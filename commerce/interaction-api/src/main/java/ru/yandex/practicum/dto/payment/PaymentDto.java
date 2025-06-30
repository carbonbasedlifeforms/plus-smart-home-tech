package ru.yandex.practicum.dto.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class PaymentDto {
    // в спецификации все указанные ниже поля не помечены как обязательные
    private UUID paymentId;

    private double totalPayment;

    private double deliveryTotal;

    private double feeTotal;
}
