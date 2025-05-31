package com.learn.hub.controllers;

import com.learn.hub.DTOs.BadgeReqDTO;
import com.learn.hub.models.Badge;
import com.learn.hub.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping(value = "/")
    public List<?> getAllBadges() {
        return this.badgeService.getAllBadges();
    }

    @PostMapping(value = "/new")
    @PreAuthorize("hasRole('PROF')")
    public ResponseEntity<Map<String,Object>> addNewBadge(@RequestBody BadgeReqDTO request) {
        Map<String,Object> response = new HashMap<>();
        Badge bg = this.badgeService.createBadge(request);
        response.put("id", bg.getId());
        response.put("name", bg.getName());
        response.put("formation", bg.getFormation());
        response.put("points", bg.getPoints());
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('prof')")
    public ResponseEntity<String> deleteBadge(@PathVariable("id") Long id) {
        this.badgeService.deleteBadge(id);
        return ResponseEntity.status(200).body("badge succesfully deleted");
    }

}
