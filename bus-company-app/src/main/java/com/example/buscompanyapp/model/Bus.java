package com.example.buscompanyapp.model;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int busNumber;
    @ManyToOne
    @JoinColumn(name = "bus_type_id", referencedColumnName = "id")
    private BusType busType;
    private String company;
    @ManyToOne
    @JoinColumn(name = "departureLocation_id", referencedColumnName = "id")
    private Location departureLocation;
    @ManyToOne
    @JoinColumn(name = "arrivalLocation_id", referencedColumnName = "id")
    private Location arrivalLocation;
    private String phoneNumber;
    private String arrivalTime;
    private String departureTime;

    public Bus() {
    }

    public Bus(int id, int busNumber, BusType busType, String company,
               Location departureLocation, Location arrivalLocation, String phoneNumber,
               String arrivalTime, String departureTime) {
        this.id = id;
        this.busNumber = busNumber;
        this.busType = busType;
        this.company = company;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.phoneNumber = phoneNumber;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
