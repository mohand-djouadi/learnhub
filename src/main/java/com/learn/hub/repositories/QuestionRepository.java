package com.learn.hub.repositories;

import com.learn.hub.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findById(Long Id);
    List<Question> findByType(String Types);
    List<Question> findByTypeContaining(String types);
    Question findByQuizId(Long quizId);
    Question findByReponseId(Long reponseId);

}
