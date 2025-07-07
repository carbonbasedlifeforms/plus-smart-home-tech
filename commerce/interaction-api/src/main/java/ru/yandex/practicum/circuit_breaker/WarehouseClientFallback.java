package ru.yandex.practicum.circuit_breaker;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.WarehouseClient;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.*;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.Map;
import java.util.UUID;

import static ru.yandex.practicum.enums.FallBackUtil.FALLBACK_MESSAGE;

@Component
public class WarehouseClientFallback implements WarehouseClient {
    @Override
    public void addNewProduct(NewProductInWarehouseRequest request) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public void addProductQuantity(AddProductToWarehouseRequest request) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public BookedProductsDto checkQuantity(ShoppingCartDto shoppingCartDto) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public AddressDto getWarehouseAddress() {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public void acceptReturn(Map<UUID, Long> products) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public void shippedToDelivery(ShippedToDeliveryRequest request) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public BookedProductsDto assemblyProductsForOrder(AssemblyProductsForOrderRequest request) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }
}
