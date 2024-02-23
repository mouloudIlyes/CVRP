package com.GoaTech.CVRP.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OsrmDto {

    @JsonProperty("routes")
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public static class Route {
        @JsonProperty("duration")
        private Long duration;

        public Long getDuration() {
            return duration;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }
    }
}
