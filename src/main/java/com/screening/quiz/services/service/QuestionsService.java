package com.screening.quiz.services.service;

import com.screening.quiz.services.model.Questions;

import java.util.List;

public interface QuestionsService {
    public List<Questions> getQuestions();
    public Questions getQuestionById(String questionId);
}
