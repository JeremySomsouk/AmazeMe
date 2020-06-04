package com.manomano.AmazeMe.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {

    @JsonProperty("spot_id")
    private String spotId;

    private String description;
}
