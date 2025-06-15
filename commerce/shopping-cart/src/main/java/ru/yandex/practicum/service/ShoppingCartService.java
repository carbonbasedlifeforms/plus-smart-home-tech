package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.shoppingcart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ShoppingCartService {
    ShoppingCartDto getUserShoppingCart(String userName);

    ShoppingCartDto addProductsToShoppingCart(String userName, Map<UUID, Long> products);

    void deactivateShoppingCart(String userName);

    ShoppingCartDto removeProductsFromShoppingCart(String userName, List<UUID> productIdList);

    ShoppingCartDto changeQuantityOfProductsInShoppingCart(String userName, ChangeProductQuantityRequest request);
}
