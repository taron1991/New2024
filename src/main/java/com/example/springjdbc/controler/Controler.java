package com.example.springjdbc.controler;

import com.example.springjdbc.dto.Car_dto;
import com.example.springjdbc.model.Car;
import com.example.springjdbc.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controler {
    private final ServiceLayer serviceLayer;

    @Autowired
    public Controler(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping("/save")
    public void save(@RequestBody Car_dto carDto) {
        serviceLayer.save(carDto);
    }

    @RequestMapping("/get")
    public List<Car> get() {
        return serviceLayer.findAll();
    }
    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable(value = "name") String name){
        serviceLayer.delete(name);
    }
    @PutMapping("/update/{name}")
    public void update(@PathVariable(value = "name") String name,@RequestBody Car_dto carDto){
        serviceLayer.update(name,carDto);
    }
    @RequestMapping("/select/{name}")
    public List<Car> findByName(@PathVariable(value = "name") String name){
    return    serviceLayer.findByName(name);
    }
}
