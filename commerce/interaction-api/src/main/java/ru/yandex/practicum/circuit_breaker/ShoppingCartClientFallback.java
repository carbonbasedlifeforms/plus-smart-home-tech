package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.ShoppingCartClient;
import ru.yandex.practicum.dto.shoppingcart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ShoppingCartClientFallback implements ShoppingCartClient {
    @Override
    public ShoppingCartDto getShoppingCart(String userName) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ShoppingCartDto addProductToShoppingCart(String userName, Map<UUID, Long> products) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void deactivateShoppingCart(String userName) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ShoppingCartDto removeProductsFromShoppingCart(String userName, List<UUID> productList) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ShoppingCartDto changeProductQuantity(String userName, ChangeProductQuantityRequest request) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }
}
