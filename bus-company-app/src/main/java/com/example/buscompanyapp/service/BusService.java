package com.example.buscompanyapp.service;
import com.example.buscompanyapp.model.Bus;
import com.example.buscompanyapp.repository.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BusService implements IBusService {

    @Autowired
    private IBusRepository busRepository;

    @Override
    public Page<Bus> findAll(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    @Override
    public void saveBus(Bus bus) {
        busRepository.saveBus(bus);
    }

    @Override
    public void deleteBusById(int id) {
        busRepository.deleteBusById(id);
    }

    @Override
    public Bus findBusById(int id) {
        return busRepository.findBusById(id);
    }

    @Override
    public void update(int id, Bus bus) {
        busRepository.update(id, bus);
    }
}
