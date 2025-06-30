package ru.yandex.practicum;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class OrderApp {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(OrderApp.class, args);
    }
}
