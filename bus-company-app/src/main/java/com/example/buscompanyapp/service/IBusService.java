package com.example.buscompanyapp.service;

import com.example.buscompanyapp.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBusService {

    Page<Bus> findAll(Pageable pageable);

    void saveBus(Bus bus);

    void deleteBusById(int id);

    Bus findBusById(int id);

    void update(int id, Bus bus);
}
