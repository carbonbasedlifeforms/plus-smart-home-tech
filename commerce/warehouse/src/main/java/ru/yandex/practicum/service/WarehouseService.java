package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.*;

import java.util.Map;
import java.util.UUID;

public interface WarehouseService {
    void addNewProduct(NewProductInWarehouseRequest request);

    BookedProductsDto checkQuantity(ShoppingCartDto shoppingCartDto);

    void addProductQuantity(AddProductToWarehouseRequest request);

    AddressDto getWarehouseAddress();

    void acceptReturn(Map<UUID, Long> products);

    void  shippedToDelivery(ShippedToDeliveryRequest request);

    BookedProductsDto assemblyProductsForOrder(AssemblyProductsForOrderRequest request);
}
