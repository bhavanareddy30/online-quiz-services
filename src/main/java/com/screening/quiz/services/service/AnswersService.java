package com.screening.quiz.services.service;

import com.screening.quiz.services.model.Answers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnswersService {
    public Answers storeFile(String userId, String questionId, String responseText, MultipartFile response);
    public List<Answers> getAnswers(String userId);
    public Answers getAnswerById(String answerId);
}
