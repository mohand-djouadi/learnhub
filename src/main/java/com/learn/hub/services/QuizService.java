package com.learn.hub.services;

import com.learn.hub.DTOs.QuizReqDTO;
import com.learn.hub.DTOs.QuizResDTO;
import com.learn.hub.models.Quiz;
import com.learn.hub.repositories.FormationRepository;
import com.learn.hub.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private FormationRepository formationRepository;

    public QuizResDTO getFormationQuizes(Long id) {
        Quiz quiz = this.quizRepository.findByFormationId(id);
        return QuizResDTO.builder()
            .id(quiz.getId())
            .name(quiz.getName())
            .build();
    }

    public QuizResDTO createQuiz(QuizReqDTO request) {
         Quiz quiz = this.quizRepository.save(
            Quiz.builder()
                .name(request.getName())
                .formation(this.formationRepository.findById(request.getFormationId()).get())
                .build()
         );
         return QuizResDTO.builder()
             .id(quiz.getId())
             .name(quiz.getName())
             .build();
    }

    public void deleteQuiz(Long id) {
        this.quizRepository.delete(this.quizRepository.findById(id).get());
    }

}
