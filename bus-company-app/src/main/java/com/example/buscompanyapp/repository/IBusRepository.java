package com.example.buscompanyapp.repository;
import com.example.buscompanyapp.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {

    @Query(value = "SELECT b.* FROM bus as b", nativeQuery = true)
    List<Bus> findAll( );
    @Modifying
    @Query(value = "INSERT INTO bus(company, arrival_time, bus_number, departure_time, phone_number, arrival_location_id, bus_type_id, departure_location_id) " +
            "VALUES (:company, :arrival_time, :bus_number, :departure_time, :phone_number, :arrival_location_id, :bus_type_id, :departure_location_id)",
            nativeQuery = true)
    void saveBus(@Param("bus") Bus bus);

    @Query(value = "DELETE FROM bus WHERE id = :id", nativeQuery = true)
    void deleteBusById(@Param("id") int id);

    @Query(value = "SELECT * FROM bus WHERE id = :id", nativeQuery = true)
    Bus findBusById(@Param("id") int id);

    @Query(value = "UPDATE bus SET company = :company, arrival_time = :arrival_time, bus_number = :bus_number, " +
            "departure_time = :departure_time, phone_number = :phone_number, arrival_location_id = :arrival_location_id, " +
            "bus_type_id = :bus_type_id, departure_location_id = :departure_location_id WHERE id = :id", nativeQuery = true)
    void update(@Param("id") int id, @Param("bus") Bus bus);
}
