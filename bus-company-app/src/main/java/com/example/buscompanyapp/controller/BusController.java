package com.example.buscompanyapp.controller;

import com.example.buscompanyapp.model.Bus;
import com.example.buscompanyapp.model.BusType;
import com.example.buscompanyapp.model.Location;
import com.example.buscompanyapp.service.IBusService;
import com.example.buscompanyapp.service.IBusTypeService;
import com.example.buscompanyapp.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BusController {
    @Autowired
    private IBusService busService;
    @Autowired
    private IBusTypeService busTypeService;
    @Autowired
    private ILocationService locationService;

    @GetMapping("/bus")
    public ResponseEntity<Page<Bus>> findAllBus(Pageable pageable) {
        Page<Bus> buses = busService.findAll(pageable);
        if (buses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity<Bus> findBusById(@PathVariable int id) {
        Bus bus = busService.findBusById(id);
        if (bus == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @PostMapping("/bus")
    public ResponseEntity<Bus> saveBus(@RequestBody Bus bus) {
        busService.saveBus(bus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/bus/{id}")
    public ResponseEntity<Bus> deleteCarById(@PathVariable int id) {
        busService.deleteBusById(id);
        Bus busDelete = busService.findBusById(id);
        return new ResponseEntity<Bus>(busDelete, HttpStatus.OK);
    }

    @PutMapping("/bus/{id}")
    public ResponseEntity<Bus> updateCar(@PathVariable int id, @RequestBody Bus bus) {
        Bus busUpdate = busService.findBusById(id);
        if (busUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        busService.update(id, busUpdate);
        return new ResponseEntity<>(busUpdate, HttpStatus.OK);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locationList = locationService.findAll();
        if (locationList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(locationList, HttpStatus.OK);
        }
    }

    @GetMapping("/busType")
    public ResponseEntity<List<BusType>> getAllBusType() {
        List<BusType> busTypes = busTypeService.findAll();
        if (busTypes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(busTypes, HttpStatus.OK);
        }
    }

}
