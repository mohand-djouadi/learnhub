package com.learn.hub.controllers;

import com.learn.hub.DTOs.ReponseReqDTO;
import com.learn.hub.DTOs.ReponseResDTO;
import com.learn.hub.services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reponse")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;

    @PostMapping(value = "/new")
    public ResponseEntity<ReponseResDTO> addNewReponse(@RequestBody ReponseReqDTO request) {
        return ResponseEntity.status(201).body(this.reponseService.createReponse(request));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteReponse(@PathVariable Long id) {
        this.reponseService.deleteReponse(id);
        return ResponseEntity.status(200).body("reponse deleted succesfully");
    }

}
