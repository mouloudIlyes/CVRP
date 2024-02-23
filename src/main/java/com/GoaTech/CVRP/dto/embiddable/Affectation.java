package com.GoaTech.CVRP.dto.embiddable;

import java.util.List;

public class Affectation {
    Long trackId;
    List<Long> orderIds;

    public Affectation() {
    }


    public Affectation(Long trackId, List<Long> orderIds) {
        this.trackId = trackId;
        this.orderIds = orderIds;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
