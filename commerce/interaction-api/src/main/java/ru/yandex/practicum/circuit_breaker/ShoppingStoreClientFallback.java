package ru.yandex.practicum.circuit_breaker;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.client.ShoppingStoreClient;
import ru.yandex.practicum.dto.shoppingstore.ProductDto;
import ru.yandex.practicum.enums.QuantityState;
import ru.yandex.practicum.exceptions.ServiceFallBackException;

import java.util.List;
import java.util.UUID;

import static ru.yandex.practicum.enums.FallBackUtil.FALLBACK_MESSAGE;

@Component
public class ShoppingStoreClientFallback implements ShoppingStoreClient {
    @Override
    public Page<ProductDto> getShoppingStoreProducts(String category, int page, int size, List<String> sort) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public Boolean deleteProduct(UUID id) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public Boolean updateQuantityState(UUID productId, QuantityState quantityState) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        throw new ServiceFallBackException(FALLBACK_MESSAGE.getMessage());
    }
}
