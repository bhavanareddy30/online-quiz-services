package com.screening.quiz.services.resources;

import com.screening.quiz.services.model.Answers;
import com.screening.quiz.services.model.Questions;
import com.screening.quiz.services.service.AnswersService;
import com.screening.quiz.services.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizResource {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    AnswersService answersService;

    @CrossOrigin
    @GetMapping("/questions")
    public List<Questions> getQuestions(){
        return questionsService.getQuestions();
    }

    @CrossOrigin
    @RequestMapping(value = "/saveAnswers", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveAnswers(@RequestParam("userId") String userId, @RequestParam("questionId") String questionId,
                               @RequestParam("responseText") String responseText, @RequestParam("data") @RequestBody MultipartFile data){
        Answers answers = answersService.storeFile(userId, questionId, responseText, data);
        return ResponseEntity.ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + answers.getId() + "\"")
                .body(answers.getResponse());
    }

    @CrossOrigin
    @GetMapping("/getAnswers")
    public List<Answers> getAnswers(@RequestParam("userId") String userId){
        return answersService.getAnswers(userId);
    }

    @CrossOrigin
    @GetMapping("/getAnswerById")
    public ResponseEntity getAnswerById(@RequestParam("answerId") String answerId){
        Answers answers = answersService.getAnswerById(answerId);
        return ResponseEntity.ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + answers.getId() + "\"")
                .body(answers.getResponse());
    }
}
