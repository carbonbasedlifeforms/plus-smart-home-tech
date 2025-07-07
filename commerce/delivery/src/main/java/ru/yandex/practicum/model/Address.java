package ru.yandex.practicum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    @Column(name = "country")
    @NotBlank
    String country;

    @Column(name = "city")
    @NotBlank
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "house")
    String house;

    @Column(name = "flat")
    String flat;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
