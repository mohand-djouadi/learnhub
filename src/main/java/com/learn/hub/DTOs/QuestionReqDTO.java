package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionReqDTO {

    @NotBlank
    private String content;
    @NotNull
    private Long quizId;

}
