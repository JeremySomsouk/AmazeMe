package com.manomano.AmazeMe.controller;

import com.manomano.AmazeMe.controller.dto.LocationDto;
import com.manomano.AmazeMe.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private final LocationsService locationsService;

    @Autowired
    LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }


    @GetMapping
    List<LocationDto> getAllLocations() {
        return locationsService.getAllLocations();
    }

    @GetMapping("/{spotId}")
    LocationDto getLocationBySpotName(@PathVariable(value = "spotId") String spotId) {
        return locationsService.findLocationInfoBySpotId(spotId);
    }
}