package com.GoaTech.CVRP.dto;

import com.GoaTech.CVRP.dto.embiddable.Coordinate;
import com.GoaTech.CVRP.dto.embiddable.Order;
import com.GoaTech.CVRP.dto.embiddable.Truck;

import java.util.List;

public class ProblemDto {
    int id;
    private Coordinate coordinatesFrom;
    List<Truck> trucks;
    List<Order> orders;

    public ProblemDto() {
    }

    public ProblemDto(int id, Coordinate coordinatesFrom, List<Truck> trucks, List<Order> orders) {
        this.id = id;
        this.coordinatesFrom = coordinatesFrom;
        this.trucks = trucks;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinate getCoordinatesFrom() {
        return coordinatesFrom;
    }

    public void setCoordinatesFrom(Coordinate coordinatesFrom) {
        this.coordinatesFrom = coordinatesFrom;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
