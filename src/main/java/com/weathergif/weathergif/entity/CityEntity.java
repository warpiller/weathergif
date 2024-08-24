package com.weathergif.weathergif.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String city;

    public CityEntity(String city) {
        this.city = city;
    }

    public CityEntity() {

    }
}
