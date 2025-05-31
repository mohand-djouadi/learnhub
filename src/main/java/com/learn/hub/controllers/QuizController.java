package com.learn.hub.controllers;

import com.learn.hub.DTOs.QuizReqDTO;
import com.learn.hub.DTOs.QuizResDTO;
import com.learn.hub.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService

    @GetMapping(value = "/{formId}")
    public ResponseEntity<QuizResDTO> getformationQuiz(@PathVariable Long formId) {
        return ResponseEntity.status(200).body(this.quizService.getFormationQuizes(formId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<QuizResDTO> addNewQuiz(@RequestBody QuizReqDTO request) {
        return ResponseEntity.status(201).body(this.quizService.createQuiz(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
        this.quizService.deleteQuiz(id);
        return ResponseEntity.status(200).body("quiz delete succesfully");
    }

}
