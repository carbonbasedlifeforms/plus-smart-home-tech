package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.OrderClient;
import ru.yandex.practicum.dto.order.CreateNewOrderRequest;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.List;
import java.util.UUID;

import static ru.yandex.practicum.enums.FallBackUtil.FALLBACK_MESSAGE;

@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public List<OrderDto> getClientOrders(String userName) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto createNewOrder(CreateNewOrderRequest request, String userName) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto payment(UUID orderId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto paymentFailed(UUID orderId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto delivery(UUID orderId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto deliveryFailed(UUID orderId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public OrderDto assembly(UUID orderId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }
}
