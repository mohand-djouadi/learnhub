package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormationReqDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Boolean premium;
    private String code;

}
