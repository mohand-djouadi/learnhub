package com.learn.hub.services;

import com.learn.hub.DTOs.QuestionReqDTO;
import com.learn.hub.models.Question;
import com.learn.hub.repositories.QuestionRepository;
import com.learn.hub.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuizQuestions(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }

    public Question createQuestion(QuestionReqDTO request) {
        return this.questionRepository.save(
            Question.builder()
                .content(request.getContent())
                .quiz(this.quizRepository.findById(request.getQuizId()).get())
                .build()
        );
    }

    public Boolean deleteQuestion(Long id) {
        this.questionRepository.delete(this.questionRepository.findById(id).get());
        return true;
    }

}
