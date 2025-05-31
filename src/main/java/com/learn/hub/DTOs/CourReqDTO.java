package com.learn.hub.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class CourReqDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Long formationId;
    @NotNull
    private MultipartFile file;

}
