package com.manomano.AmazeMe.mapper;

import com.manomano.AmazeMe.controller.dto.LocationDto;
import com.manomano.AmazeMe.repository.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationsMapper implements Mapper<LocationDto, Location> {

    public final LocationDto toDto(Location location) {

        return LocationDto.builder()
                .spotId(location.getSpotId())
                .description(location.getDescription())
                .build();
    }

    public final Location toModel(LocationDto locationDto) {

        return Location.builder()
                .spotId(locationDto.getSpotId())
                .description(locationDto.getDescription())
                .build();
    }
}
