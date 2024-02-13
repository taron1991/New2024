package com.example.springjdbc.model;

/*
придумать способ через полиморфизм
либо через спринг jdbc
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "color")
    private String color;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "localdate")
    private LocalDate localDate;
    @Column(name = "wincode")
    private int wincode;

    public Car(int id, String color, String name, int price, LocalDate localDate, int wincode) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.price = price;
        this.localDate = localDate;
        this.wincode = wincode;
    }

    public Car() {

    }
}
