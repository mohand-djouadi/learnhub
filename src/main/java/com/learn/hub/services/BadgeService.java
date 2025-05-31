package com.learn.hub.services;

import com.learn.hub.DTOs.BadgeReqDTO;
import com.learn.hub.models.Badge;
import com.learn.hub.repositories.BadgeRepository;
import com.learn.hub.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private FormationRepository formationRepository;

    public List<Badge> getAllBadges() {
        return this.badgeRepository.findAll();
    }

    public Badge createBadge(BadgeReqDTO request) {
        return this.badgeRepository.save(
            Badge.builder()
                .name(request.getName())
                .points(request.getPoints())
                .formation(this.formationRepository.findById(request.getFormationId()).get())
                .build()
        );
    }

    public Boolean deleteBadge(Long id) {
        this.badgeRepository.delete(this.badgeRepository.findById(id).get());
        return true;
    }

}
