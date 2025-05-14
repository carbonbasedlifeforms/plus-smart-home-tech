package ru.yandex.practicum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "sensors")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Sensor {
    @Id
    @Column(name = "id")
    String id;

    @Column(name = "hub_id", nullable = false)
    String hubId;

//    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<Condition> conditions;
//
//    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<Action> actions;
}
