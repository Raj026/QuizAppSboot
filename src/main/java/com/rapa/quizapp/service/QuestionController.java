package com.rapa.quizapp.service;

import com.rapa.quizapp.Question;
import com.rapa.quizapp.controller.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This is to make the program understand that this is controller class
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    //If you mention {cat} in here then you have to make changes in the path variable
    //i.e.- @Pathvariable("cat") String category
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);

    }
}
