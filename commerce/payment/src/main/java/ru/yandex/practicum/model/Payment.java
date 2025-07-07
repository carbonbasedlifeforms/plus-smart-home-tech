package ru.yandex.practicum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.dto.payment.PaymentState;

import java.util.UUID;

@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    UUID id;

    @Column(name = "order_id")
    @NotNull
    UUID orderId;

    @Column(name = "products_total")
    double productsTotal;

    @Column(name = "delivery_total")
    double deliveryTotal;

    @Column(name = "total_payment")
    double totalPayment;

    @Column(name = "fee_total")
    double feeTotal;

    @Column(name = "payment_state")
    @Enumerated(EnumType.STRING)
    PaymentState paymentState;
}
