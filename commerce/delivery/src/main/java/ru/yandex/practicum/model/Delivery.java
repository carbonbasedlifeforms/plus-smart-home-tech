package ru.yandex.practicum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.enums.DeliveryState;

import java.util.UUID;

@Entity
@Table(name = "order_delivery")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    @Column(name = "total_volume")
    double totalVolume;

    @Column(name = "total_weight")
    double totalWeight;

    @Column(name = "fragile")
    boolean isFragile;

    @ManyToOne
    @JoinColumn(name = "from_address_id")
    @NotNull
    Address fromAddress;

    @ManyToOne
    @JoinColumn(name = "to_address_id")
    @NotNull
    Address toAddress;

    @Column(name = "order_id")
    @NotNull
    UUID orderId;

    @Enumerated(EnumType.STRING)
    @NotNull
    DeliveryState deliveryState;
}
