package com.learn.hub.controllers;

import com.learn.hub.DTOs.FormationReqDTO;
import com.learn.hub.DTOs.FormationResDTO;
import com.learn.hub.models.Formation;
import com.learn.hub.repositories.FormationRepository;
import com.learn.hub.services.FormationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping(value= "/")
    public ResponseEntity<List<FormationResDTO>> getFormation() {
        return ResponseEntity.status(200).body(this.formationService.getFormations());
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Formation> addNewFormation(@RequestBody FormationReqDTO request) {
        return ResponseEntity.status(201).body(this.formationService.createFormation(request));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {
        return ResponseEntity.status(200).body("formation deleted succesfully");
    }

}
