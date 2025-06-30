package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.shoppingcart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.*;
import ru.yandex.practicum.service.WarehouseService;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void addNewProduct(@RequestBody @Valid NewProductInWarehouseRequest request) {
        log.info("adding new product {} to warehouse", request);
        warehouseService.addNewProduct(request);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addProductQuantity(@RequestBody @Valid AddProductToWarehouseRequest request) {
        log.info("adding quantity product {} to warehouse", request);
        warehouseService.addProductQuantity(request);
    }

    @PostMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public BookedProductsDto checkQuantity(@RequestBody @Valid ShoppingCartDto shoppingCartDto) {
        log.info("checking product {} in warehouse", shoppingCartDto);
        return warehouseService.checkQuantity(shoppingCartDto);
    }

    @GetMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public AddressDto getWarehouseAddress() {
        log.info("getting warehouse address");
        return warehouseService.getWarehouseAddress();
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public void acceptReturn(@RequestBody Map<UUID, Long> products) {
        log.info("accepting return {}", products);
        warehouseService.acceptReturn(products);
    }

    @PostMapping("/shipped")
    @ResponseStatus(HttpStatus.OK)
    public void shippedToDelivery(@RequestBody @Valid ShippedToDeliveryRequest request) {
        log.info("shipped to delivery {}", request);
        warehouseService.shippedToDelivery(request);
    }

    @PostMapping("/assembly")
    @ResponseStatus(HttpStatus.OK)
    public BookedProductsDto assemblyProductsForOrder(@RequestBody @Valid AssemblyProductsForOrderRequest request) {
        log.info("assembly products for order {}", request);
        return warehouseService.assemblyProductsForOrder(request);
    }
}
