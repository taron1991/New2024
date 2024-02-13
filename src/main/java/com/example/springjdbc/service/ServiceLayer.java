package com.example.springjdbc.service;

import com.example.springjdbc.dao.DaoLayer;
import com.example.springjdbc.dto.Car_dto;
import com.example.springjdbc.model.Car;
import com.example.springjdbc.repository.JDBCLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceLayer {
    private final DaoLayer daoLayer;

    @Autowired
    public ServiceLayer(DaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    public void save(Car_dto carDto) {
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setName(carDto.getName());
        car.setPrice(carDto.getPrice());
        car.setLocalDate(LocalDate.of(generateYear(), generateMount(), generateDay()));
        car.setWincode(generateWin());
        //  daoLayer.save(car);

    }

    private int generateWin() {
        return (int) (Math.random() * 100000 + 1000);
    }

    private int generateYear() {
        return (int) (Math.random() * 75 + 1950);
    }

    private int generateMount() {
        return (int) (Math.random() * 11 + 1);
    }

    private int generateDay() {
        return (int) (Math.random() * 29 + 1);
    }

    public List<Car> findAll() {
        return daoLayer.findAll();
    }

    public void delete(String name) {
        daoLayer.delete(name);
    }

    public void update(String name, Car_dto carDto) {
        List<Car> select = findByName(name);
        for (Car car : select) {
            car.setName(carDto.getName());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            //  daoLayer.update(name,car);
        }

    }

    public List<Car> findByName(String name) {
        return daoLayer.findByName(name);
    }
}
