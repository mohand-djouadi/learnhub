package com.learn.hub.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResDTO {

    private String content;
    private Long id;

}
