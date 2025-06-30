package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.PaymentClient;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.dto.payment.PaymentDto;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.UUID;

@Component
public class PaymentClientFallback implements PaymentClient {
    @Override
    public PaymentDto processPayment(OrderDto orderDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public Double getTotalCost(OrderDto orderDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void emulatePaymentSuccess(UUID paymentId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public Double getProductsCost(OrderDto orderDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void emulatePaymentFailed(UUID paymentId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }
}
