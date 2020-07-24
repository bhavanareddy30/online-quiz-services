package com.screening.quiz.services.service;

import com.screening.quiz.services.model.Answers;
import com.screening.quiz.services.model.Questions;
import com.screening.quiz.services.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    AnswersRepository answersRepository;

    @Autowired
    QuestionsService questionsService;

    @Override
    public List<Answers> getAnswers(String userId){
        return answersRepository.findByUserIdOrderByCreatedDateTimeAsc(userId);
    }

    @Override
    public Answers getAnswerById(String answerId){
        System.out.println("AnswerId"+answerId);
        return answersRepository.findById(answerId).orElseThrow(() -> new RuntimeException("AnswerId does not exist"));
    }

    @Override
    public Answers storeFile(String userId, String questionId, String responseText, MultipartFile response){
        Questions questions = questionsService.getQuestionById(questionId);
        List<Answers> existingAnswers = answersRepository.findByUserIdAndQuestionId(userId, questionId);
        if(existingAnswers.size() > 1){
            throw new RuntimeException("Should never happen");
        }

        Answers answers = null;
        try {
            if(!CollectionUtils.isEmpty(existingAnswers)){
                Answers answers1 = existingAnswers.get(0);
                answers1.setResponse(response.getBytes());
                answers1.setResponseText(responseText);
                answers1.setUpdatedDateTime(new Date());
                return answersRepository.save(answers1);
            }
            answers = new Answers(userId, questionId, questions.getQuestion(), response.getBytes(), responseText);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save answers");
        }
        return answersRepository.save(answers);
    }
}
