package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.shoppingstore.ProductDto;
import ru.yandex.practicum.enums.ProductCategory;
import ru.yandex.practicum.enums.QuantityState;
import ru.yandex.practicum.service.ShoppingStoreService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/shopping-store")
@RequiredArgsConstructor
public class ShoppingStoreController {
    private final ShoppingStoreService shoppingStoreService;

    @GetMapping
    public Page<ProductDto> getShoppingStoreProducts(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "", required = false) List<String> sort
    ) {
        List<Sort.Order> orderList = sort.stream()
                .map(s -> new Sort.Order(Sort.Direction.ASC, s))
                .toList();
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderList));
        log.info("Get products by category: {}", category);
        return shoppingStoreService.getProducts(ProductCategory.valueOf(category), pageable);
    }

    @PutMapping
    public ProductDto createProduct(@RequestBody @Valid ProductDto productDto) {
        log.info("Create product: {}", productDto);
        return shoppingStoreService.createProduct(productDto);
    }

    @PostMapping
    public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto) {
        log.info("Update product: {}", productDto);
        return shoppingStoreService.updateProduct(productDto);
    }

    @PostMapping("/removeProductFromStore")
    public Boolean deleteProduct(@RequestBody UUID id) {
        log.info("Remove product from store: {}", id);
        return shoppingStoreService.deleteProduct(id);
    }

    @PostMapping("/quantityState")
    public Boolean updateQuantityState(@RequestParam UUID productId, @RequestParam QuantityState quantityState) {
        log.info("Update product {} quantity: {}", productId, quantityState);
        return shoppingStoreService.updateQuantityState(productId, quantityState);
    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable UUID productId) {
        log.info("Get product by id: {}", productId);
        return shoppingStoreService.getProductById(productId);
    }
}
