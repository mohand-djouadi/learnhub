package com.learn.hub.services;

import com.learn.hub.DTOs.FormationReqDTO;
import com.learn.hub.DTOs.FormationResDTO;
import com.learn.hub.enums.Role;
import com.learn.hub.models.Formation;
import com.learn.hub.models.User;
import com.learn.hub.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public List<FormationResDTO> getFormations() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        List<FormationResDTO> forms = new ArrayList<>();
        if (user == null) {
            this.formationRepository.findByPremium(false).forEach(f -> {
                forms.add(
                    FormationResDTO.builder()
                        .id(f.getId())
                        .description(f.getDescription())
                        .title(f.getTitle())
                        .prof(f.getProf().getId())
                        .build()
                );
            });
        } else {
            this.formationRepository.findAll().forEach(f -> {
                forms.add(
                    FormationResDTO.builder()
                        .id(f.getId())
                        .description(f.getDescription())
                        .title(f.getTitle())
                        .prof(f.getProf().getId())
                        .build()
                );
            });
        }
        return forms;
    }

    public Formation createFormation(FormationReqDTO request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        return this.formationRepository.save(
            Formation.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .premium(request.getPremium())
                .code(request.getCode())
                .prof(user)
                .build()
        );
    }

    public Boolean deleteFormation(Long id) {
        this.formationRepository.delete(this.formationRepository.findById(id).get());
        return true;
    }

}
