package com.example.springjdbc.repository;

import com.example.springjdbc.dao.DaoLayer;
import com.example.springjdbc.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Primary
public interface HibernateDataLayer extends   JpaRepository<Car,Integer> {




   /* @Query(value = "DELETE from car Where name =:name ",nativeQuery = true)
    public void delete(@Param("name") String name);*/
   /* @Query(value = "SELECT * from car where name=:name",nativeQuery = true)
    public List<Car> findByName(@Param(value = "name") String name);*/

}
