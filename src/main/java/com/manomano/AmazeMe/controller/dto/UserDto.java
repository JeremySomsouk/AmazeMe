package com.manomano.AmazeMe.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String username;

    private String action;

    private String job;

    private String advice;
}
