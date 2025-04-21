package com.learn.hub.controllers;

import com.learn.hub.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String addNewBadge() {
        return "this new badge path";
    }

}
