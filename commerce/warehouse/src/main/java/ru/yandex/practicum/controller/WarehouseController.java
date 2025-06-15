package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.AddProductToWarehouseRequest;
import ru.yandex.practicum.dto.warehouse.AddressDto;
import ru.yandex.practicum.dto.warehouse.BookedProductsDto;
import ru.yandex.practicum.dto.warehouse.NewProductInWarehouseRequest;
import ru.yandex.practicum.service.WarehouseService;

@Slf4j
@RestController
@RequestMapping("/api/v1/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PutMapping
    public void addNewProduct(@RequestBody @Valid NewProductInWarehouseRequest request) {
        log.info("adding new product {} to warehouse", request);
        warehouseService.addNewProduct(request);
    }

    @PostMapping("/add")
    public void addProductQuantity(@RequestBody @Valid AddProductToWarehouseRequest request) {
        log.info("adding quantity product {} to warehouse", request);
        warehouseService.addProductQuantity(request);
    }

    @PostMapping("/check")
    public BookedProductsDto checkQuantity(@RequestBody @Valid ShoppingCartDto shoppingCartDto) {
        log.info("checking product {} in warehouse", shoppingCartDto);
        return warehouseService.checkQuantity(shoppingCartDto);
    }

    @GetMapping("/address")
    public AddressDto getWarehouseAddress() {
        log.info("getting warehouse address");
        return warehouseService.getWarehouseAddress();
    }
}
