package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.shoppingcart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.service.ShoppingCartService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public ShoppingCartDto getShoppingCart(@RequestParam(name = "username") String userName) {
        log.info("Getting shopping cart for user {}", userName);
        return shoppingCartService.getUserShoppingCart(userName);
    }

    @PutMapping
    public ShoppingCartDto addProductToShoppingCart(
            @RequestParam(name = "username") String userName,
            @RequestBody Map<UUID, Long> products) {
        log.info("Adding products {} to shopping cart for user {}", products, userName);
        return shoppingCartService.addProductsToShoppingCart(userName, products);
    }

    @DeleteMapping
    public void deactivateShoppingCart(@RequestParam(name = "username") String userName) {
        log.info("Deactivating shopping cart for user {}", userName);
        shoppingCartService.deactivateShoppingCart(userName);
    }

    @PostMapping("/remove")
    public ShoppingCartDto removeProductsFromShoppingCart(
            @RequestParam(name = "username") String userName,
            @RequestBody List<UUID> productList) {
        log.info("Removing products {} from shopping cart for user {}", productList, userName);
        return shoppingCartService.removeProductsFromShoppingCart(userName, productList);
    }

    @PostMapping("/change-quantity")
    public ShoppingCartDto changeProductQuantity(
            @RequestParam(name = "username") String userName,
            @RequestBody ChangeProductQuantityRequest request) {
        log.info("Changing quantity of products {} in shopping cart for user {}", request, userName);
        return shoppingCartService.changeQuantityOfProductsInShoppingCart(userName, request);
    }
}
