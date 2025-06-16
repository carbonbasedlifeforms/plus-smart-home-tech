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
    private String country;

    private String city;

    private String street;

    private String house;

    private String flat;
}
