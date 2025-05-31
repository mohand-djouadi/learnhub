package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadgeReqDTO {

    @NotBlank
    private String name;
    @NotNull
    private int points;
    @NotNull
    private Long formationId;

}
