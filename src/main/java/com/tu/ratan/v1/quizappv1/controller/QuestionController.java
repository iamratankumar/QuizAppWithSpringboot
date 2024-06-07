package com.tu.ratan.v1.quizappv1.controller;

import com.tu.ratan.v1.quizappv1.model.Question;
import com.tu.ratan.v1.quizappv1.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllquestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQiestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.saveUpdateQuestion(question);
    }

    @DeleteMapping("delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(@RequestParam Integer questionId){
        return questionService.deleteQuestion(questionId);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.saveUpdateQuestion(question);
    }

}