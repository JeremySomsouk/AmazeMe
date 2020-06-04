package com.manomano.AmazeMe.service;

import com.manomano.AmazeMe.controller.dto.LocationDto;
import com.manomano.AmazeMe.controller.exception.LocationNotFoundException;
import com.manomano.AmazeMe.mapper.LocationsMapper;
import com.manomano.AmazeMe.repository.LocationsRepository;
import com.manomano.AmazeMe.repository.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class LocationsService {

    private LocationsRepository locationsRepository;
    private LocationsMapper locationsMapper;
    public static String hint2 = "FLYYOUFOOLS!";

    @Autowired
    public LocationsService(LocationsRepository locationsRepository,
                            LocationsMapper locationsMapper) {
        this.locationsRepository = locationsRepository;
        this.locationsMapper = locationsMapper;
    }

    public LocationDto findLocationInfoBySpotId(String spotId) {

        Location location = locationsRepository.findById(spotId)
                .orElseThrow(() -> new LocationNotFoundException(String.format("Location not found : spot name = %s", spotId)));

        setDescriptionHint(location);

        return locationsMapper.toDto(location);
    }

    public List<LocationDto> getAllLocations() {

        List<Location> allLocations = locationsRepository.findAll();
        return allLocations.stream()
                .map(location -> locationsMapper.toDto(location))
                .collect(toList());
    }

    private void setDescriptionHint(Location location) {
        if ("forest".equals(location.getSpotId())) {
            location.setDescription("You found a letter buried in the dirt near a rock. It is written : " + hint2);
        } else if ("mountain".equals(location.getSpotId())) {
            location.setDescription("You found an suspicious man guarding the entry of a cave.");
        } else if ("beach".equals(location.getSpotId())) {
            location.setDescription("You found a written sentence in the sand. It is written : HELP");
        } else {
            location.setDescription("You found nothing");
        }
    }
}
