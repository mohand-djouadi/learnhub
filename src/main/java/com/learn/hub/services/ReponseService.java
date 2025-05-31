package com.learn.hub.services;

import com.learn.hub.DTOs.ReponseReqDTO;
import com.learn.hub.models.Question;
import com.learn.hub.models.Reponse;
import com.learn.hub.repositories.QuestionRepository;
import com.learn.hub.repositories.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ReponseRepository reponseRepository;

    public Reponse getQuestionReponse(Long questId) {
        return this.reponseRepository.findByQuestionId(questId);
    }

    public Reponse createReponse(ReponseReqDTO request) {
        return this.reponseRepository.save(
            Reponse.builder()
                .content(request.getContent())
                .istrue(request.getIsTrue())
                .question(this.questionRepository.findById(request.getQuestionId()).get())
                .build()
        );
    }

    public Boolean deleteReponse(Long id) {
        this.reponseRepository.delete(this.reponseRepository.findById(id).get());
        return true;
    }

}
