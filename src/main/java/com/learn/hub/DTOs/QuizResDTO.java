package com.learn.hub.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizResDTO {

    private String name;
    private Long id;

}
