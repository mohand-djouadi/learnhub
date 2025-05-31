package com.learn.hub.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormationResDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean premium;
    private Long prof;

}
