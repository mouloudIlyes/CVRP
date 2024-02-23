package com.GoaTech.CVRP.dto.embiddable;

public class Truck {
    Long id;
    Float capacity;

    public Truck() {
    }

    public Truck(Long id, Float capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCapacity() {
        return capacity;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }
}
