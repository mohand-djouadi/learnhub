package com.learn.hub.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReponseResDTO {

    private String content;
    private Boolean isTrue;
    private Long questId;
    private Long id;

}
