package com.example.springjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
public class Car_dto {
    private String color;
    private String name;
    private int price;

}
