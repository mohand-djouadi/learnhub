package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizReqDTO {

    @NotBlank
    private String name;
    @NotNull
    private Long formationId;

}
