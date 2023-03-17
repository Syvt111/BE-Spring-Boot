package com.example.buscompanyapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "departureLocation")
    private Set<Bus> busDepartSet;
    @OneToMany(mappedBy = "arrivalLocation")
    private Set<Bus> busArriSet;

    public Location() {
    }

    public Location(int id, String name, Set<Bus> busDepartSet, Set<Bus> busArriSet) {
        this.id = id;
        this.name = name;
        this.busDepartSet = busDepartSet;
        this.busArriSet = busArriSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bus> getBusDepartSet() {
        return busDepartSet;
    }

    public void setBusDepartSet(Set<Bus> busDepartSet) {
        this.busDepartSet = busDepartSet;
    }

    public Set<Bus> getBusArriSet() {
        return busArriSet;
    }

    public void setBusArriSet(Set<Bus> busArriSet) {
        this.busArriSet = busArriSet;
    }
}
