package com.rapa.quizapp.controller;

import com.rapa.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    //localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz used this to give the input through the URL params
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
//        return new ResponseEntity<>("Execute the createQuiz", HttpStatus.OK);
        return quizService.createQuiz(category,numQ, title);
    }
}
