package com.screening.quiz.services.repositories;

import com.screening.quiz.services.model.Answers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends CrudRepository<Answers, String> {

    List<Answers> findByUserIdAndQuestionId(String userId, String questionId);
    List<Answers> findByUserIdOrderByCreatedDateTimeAsc(String userId);
}
