package ru.yandex.practicum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.enums.OrderState;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    UUID id;

    @Column(name = "shopping_cart_id")
    @NotNull
    UUID shoppingCartId;

    @Column(name = "user_name")
    @NotNull
    String userName;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    @NotNull
    Map<UUID, Long> products;

    @Column(name = "payment_id")
    UUID paymentId;

    @Column(name = "delivery_id")
    UUID deliveryId;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    Address deliveryAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state")
    @NotNull
    OrderState state;

    @Column(name = "delivery_weight")
    Double deliveryWeight;

    @Column(name = "delivery_volume")
    Double deliveryVolume;

    @Column(name = "fragile")
    Boolean isFragile;

    @Column(name = "total_price")
    Double totalPrice;

    @Column(name = "delivery_price")
    Double deliveryPrice;

    @Column(name = "product_price")
    Double productPrice;
}
