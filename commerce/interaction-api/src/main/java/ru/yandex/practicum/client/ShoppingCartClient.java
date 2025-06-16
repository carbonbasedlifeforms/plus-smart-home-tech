package ru.yandex.practicum.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.shoppingcart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@FeignClient(name = "shopping-cart", path = "/api/v1/shopping-cart")
public interface ShoppingCartClient {
    @GetMapping
    ShoppingCartDto getShoppingCart(@RequestParam(name = "username") String userName);

    @PutMapping
    ShoppingCartDto addProductToShoppingCart(@RequestParam(name = "username") String userName,
                                             @RequestBody Map<UUID, Long> products);

    @DeleteMapping
    void deactivateShoppingCart(@RequestParam(name = "username") String userName);

    @PostMapping("/remove")
    ShoppingCartDto removeProductsFromShoppingCart(@RequestParam(name = "username") String userName,
                                                   @RequestBody List<UUID> productList);

    @PostMapping("/change-quantity")
    ShoppingCartDto changeProductQuantity(@RequestParam(name = "username") String userName,
                                          @RequestBody ChangeProductQuantityRequest request);
}
