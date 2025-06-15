package ru.yandex.practicum.dto.warehouse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AddressDto {
    String country;

    String city;

    String street;

    String house;

    String flat;
}
