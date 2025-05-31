package com.learn.hub.services;

import com.learn.hub.DTOs.CourReqDTO;
import com.learn.hub.models.Cour;
import com.learn.hub.repositories.CourRepository;
import com.learn.hub.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CourService {

    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private CourRepository courRepository;

    public List<Cour> getFormationCours(Long formationId) {
        return this.courRepository.findByFormationId(formationId);
    }

    public Cour addCour(CourReqDTO request) throws IOException {
        return this.courRepository.save(
            Cour.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .formation(this.formationRepository.findById(request.getFormationId()).get())
                .url(this.cloudinaryService.uploadFile(request.getFile()))
                .build()
        );
    }

    public Boolean deleteCour(Long courId) {
        this.courRepository.delete(this.courRepository.findById(courId).get());
        return true;
    }

}
