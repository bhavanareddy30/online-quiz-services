package com.screening.quiz.services.repositories;

import com.screening.quiz.services.model.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends CrudRepository<Questions, String> {
}
