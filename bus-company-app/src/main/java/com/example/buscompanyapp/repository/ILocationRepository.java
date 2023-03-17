package com.example.buscompanyapp.repository;

import com.example.buscompanyapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ILocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "SELECT * FROM bus", nativeQuery = true)
    List<Location> findAll();
}
