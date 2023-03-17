package com.example.buscompanyapp.service;

import com.example.buscompanyapp.model.BusType;
import com.example.buscompanyapp.repository.IBusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusTypeService implements IBusTypeService {
    @Autowired
    private IBusTypeRepository busTypeRepository;

    @Override
    public List<BusType> findAll() {
        return busTypeRepository.findAll();
    }
}
