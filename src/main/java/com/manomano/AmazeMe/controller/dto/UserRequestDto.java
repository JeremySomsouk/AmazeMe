package com.manomano.AmazeMe.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDto {

    private ActionEnum action;
    private String sentence;
}
