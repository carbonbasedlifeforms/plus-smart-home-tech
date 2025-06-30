package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.DeliveryClient;
import ru.yandex.practicum.dto.delivery.DeliveryDto;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.UUID;

@Component
public class DeliveryClientFallback implements DeliveryClient {
    @Override
    public DeliveryDto planDelivery(DeliveryDto deliveryDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void deliverySuccessful(UUID deliveryId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void deliveryPicked(UUID deliveryId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void deliveryFailed(UUID deliveryId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public Double deliveryCost(OrderDto orderDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }
}
