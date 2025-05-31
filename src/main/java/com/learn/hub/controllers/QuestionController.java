package com.learn.hub.controllers;

import com.learn.hub.DTOs.QuestionReqDTO;
import com.learn.hub.DTOs.QuestionResDTO;
import com.learn.hub.models.Question;
import com.learn.hub.repositories.QuestionRepository;
import com.learn.hub.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/{quizId}")
    public ResponseEntity<List<Question>> getQuizQuestions(@PathVariable Long quizId){
        return ResponseEntity.status(200).body(this.questionService.getQuizQuestions(quizId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<QuestionResDTO> addNewQuestion(@RequestBody QuestionReqDTO request) {
        return ResponseEntity.status(201).body(this.questionService.createQuestion(request));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        return ResponseEntity.status(200).body("question deleted succesfully");
    }

}
