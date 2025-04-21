package com.learn.hub.services;

import com.learn.hub.models.Badge;
import com.learn.hub.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> getAllBadges() {
        return this.badgeRepository.findAll();
    }

}
