package com.rapa.quizapp.controller;

import com.rapa.quizapp.model.Question;
import com.rapa.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // This is to make the program understand that this is controller class
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        // This will return the response with the 200 Status code and notify the user that the response generated is perfectly working.
        // We can also do this above thing in the service layer instead of controller layer.
    }

    @GetMapping("category/{category}")
    //If you mention {cat} in here then you have to make changes in the path variable
    //i.e.- @Pathvariable("cat") String category
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        try {
            return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
}
