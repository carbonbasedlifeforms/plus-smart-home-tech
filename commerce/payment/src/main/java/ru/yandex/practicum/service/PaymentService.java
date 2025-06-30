package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.dto.payment.PaymentDto;

import java.util.UUID;

public interface PaymentService {
    PaymentDto processPayment(OrderDto order);

    Double getTotalCost(OrderDto order);

    void emulatePaymentSuccess(UUID paymentId);

    Double getProductsCost(OrderDto order);

    void emulatePaymentFailed(UUID paymentId);
}
