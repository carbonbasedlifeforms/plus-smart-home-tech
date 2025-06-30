package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.WarehouseClient;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.*;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.Map;
import java.util.UUID;

@Component
public class WarehouseClientFallback implements WarehouseClient {
    @Override
    public void addNewProduct(NewProductInWarehouseRequest request) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void addProductQuantity(AddProductToWarehouseRequest request) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public BookedProductsDto checkQuantity(ShoppingCartDto shoppingCartDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public AddressDto getWarehouseAddress() {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void acceptReturn(Map<UUID, Long> products) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public void shippedToDelivery(ShippedToDeliveryRequest request) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public BookedProductsDto assemblyProductsForOrder(AssemblyProductsForOrderRequest request) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }
}
