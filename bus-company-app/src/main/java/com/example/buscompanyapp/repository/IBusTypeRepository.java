package com.example.buscompanyapp.repository;
import com.example.buscompanyapp.model.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface IBusTypeRepository extends JpaRepository<BusType, Integer> {
    @Query(value = "SELECT * FROM bus", nativeQuery = true)
    List<BusType> findAll();
}
