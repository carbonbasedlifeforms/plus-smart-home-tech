package ru.yandex.practicum.circuit_breaker;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.ShoppingStoreClient;
import ru.yandex.practicum.dto.shoppingstore.ProductDto;
import ru.yandex.practicum.enums.QuantityState;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.List;
import java.util.UUID;

@Component
public class ShoppingStoreClientFallback implements ShoppingStoreClient {
    @Override
    public Page<ProductDto> getShoppingStoreProducts(String category, int page, int size, List<String> sort) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public Boolean deleteProduct(UUID id) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public Boolean updateQuantityState(UUID productId, QuantityState quantityState) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        throw new ServiceFallBackException("service is temporarily unavailable");
    }
}
