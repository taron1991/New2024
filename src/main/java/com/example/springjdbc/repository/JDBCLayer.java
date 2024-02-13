package com.example.springjdbc.repository;

import com.example.springjdbc.dao.DaoLayer;
import com.example.springjdbc.dto.Car_dto;
import com.example.springjdbc.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCLayer implements DaoLayer {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCLayer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String saveQuery = "INSERT into car (color,name,price,localdate,wincode)VALUES (?,?,?,?,?)";
    private static final String getQuery = "SELECT * from car";
    private static final String deleteQuery = "DELETE from car Where name = ?";
    private static final String selectQuery = "SELECT * from car where name=?";
    private static final String updateQuery= "Update car set name=?,color=?,price=? where name=?";

    public void save(Car car) {
        jdbcTemplate.update(saveQuery, car.getColor(), car.getName(), car.getPrice(), car.getLocalDate(), car.getWincode());
    }


    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        jdbcTemplate.query(getQuery, new Object[]{}, (res) -> {
            cars.add(new Car(res.getInt(1),res.getString(2), res.getString(3), res.getInt(4), res.getDate(5).toLocalDate(), res.getInt(6)));
        });
        return cars;
    }

    public void delete(String name) {
        jdbcTemplate.update(deleteQuery,name);
    }

    public List<Car> findByName(String name) {
     List<Car> cars = new ArrayList<>();
        jdbcTemplate.query(selectQuery,new Object[]{name},(res)->{
           cars.add( new Car(res.getInt(1),res.getString(2), res.getString(3), res.getInt(4), res.getDate(5).toLocalDate(), res.getInt(6)));
        });
        return cars;


    }

    public void update(String name, Car car) {
        jdbcTemplate.update(updateQuery,car.getName(),car.getColor(),car.getPrice(),name);
    }
}
