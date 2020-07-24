package com.screening.quiz.services.service;

import com.screening.quiz.services.model.Questions;
import com.screening.quiz.services.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public List<Questions> getQuestions() {
        return (List<Questions>) questionsRepository.findAll();
    }

    @Override
    public Questions getQuestionById(String questionId) {
        Optional<Questions> byId = questionsRepository.findById(questionId);
        return byId.orElseThrow(() -> new RuntimeException("QuestionId does not exist"));
    }
}
