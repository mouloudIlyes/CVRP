package com.GoaTech.CVRP.dto.embiddable;

public class Coordinate {
    Long lat;
    Long lon;
    public Coordinate() {
    }
    public Coordinate(Long lat, Long lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }
}
