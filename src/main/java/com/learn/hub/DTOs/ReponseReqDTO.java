package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReponseReqDTO {

    @NotBlank
    private String content;
    @NotNull
    private Boolean isTrue;
    @NotNull
    private Long questionId;

}
