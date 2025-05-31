package com.learn.hub.services;

import com.learn.hub.DTOs.QuizReqDTO;
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

    public List<Quiz> getAllQuizes() {
        return this.quizRepository.findAll();
    }

    public Quiz createQuiz(QuizReqDTO request) {
        return this.quizRepository.save(
            Quiz.builder()
                .name(request.getName())
                .formation(this.formationRepository.findById(request.getFormationId()).get())
                .build()
        );
    }

}
