package com.learn.hub.controllers;

import com.learn.hub.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class CloudinaryController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            return cloudinaryService.uploadFile(file);
        } catch (IOException e) {
            return "Erreur d'upload: " + e.getMessage();
        }
    }

}
