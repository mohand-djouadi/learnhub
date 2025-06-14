package com.learn.hub.services;

import com.learn.hub.DTOs.QuestionReqDTO;
import com.learn.hub.DTOs.QuestionResDTO;
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

    public QuestionResDTO createQuestion(QuestionReqDTO request) {
         Question quest = this.questionRepository.save(
            Question.builder()
                .content(request.getContent())
                .quiz(this.quizRepository.findById(request.getQuizId()).get())
                .build()
         );
         return QuestionResDTO.builder()
             .id(quest.getId())
             .content(quest.getContent())
             .build();
    }

    public Boolean deleteQuestion(Long id) {
        this.questionRepository.delete(this.questionRepository.findById(id).get());
        return true;
    }

}
