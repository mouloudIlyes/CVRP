package com.GoaTech.CVRP.dto.embiddable;

public class Order {
    private Long id;
    private Float wight;
    private Coordinate coordinatesTo;

    public Order() {
    }

    public Order(Long id, Float wight, Coordinate coordinatesTo) {
        this.id = id;
        this.wight = wight;
        this.coordinatesTo = coordinatesTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWight() {
        return wight;
    }

    public void setWight(Float wight) {
        this.wight = wight;
    }

    public Coordinate getCoordinatesTo() {
        return coordinatesTo;
    }

    public void setCoordinatesTo(Coordinate coordinatesTo) {
        this.coordinatesTo = coordinatesTo;
    }
}
