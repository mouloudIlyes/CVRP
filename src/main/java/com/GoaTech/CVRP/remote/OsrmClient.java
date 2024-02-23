package com.GoaTech.CVRP.remote;

import com.GoaTech.CVRP.dto.OsrmDto;
import com.GoaTech.CVRP.dto.embiddable.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class OsrmClient {
    @Autowired
    private final RestTemplate restTemplate;

    @Value("${osrm.api.url}")
    private String osrmApiUrl;
    public OsrmClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Long getDuration(Coordinate start, Coordinate end) {
        String apiUrl = String.format("%s/route/v1/driving/%f,%f;%f,%f?overview=false", osrmApiUrl, start.getLon(), start.getLat(), end.getLon(), end.getLat());

        // Make the API request
        OsrmDto response = restTemplate.getForObject(apiUrl, OsrmDto.class);

        // Extract duration from the response
        if (response != null && response.getRoutes() != null && !response.getRoutes().isEmpty()) {
            return response.getRoutes().get(0).getDuration();
        }

        return null;
    }
}

