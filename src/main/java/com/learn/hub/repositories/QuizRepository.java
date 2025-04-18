package com.learn.hub.repositories;

import com.learn.hub.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findById(Long Id);
    List<Quiz> findByName(String name);
    List<Quiz> findByNameContaining(String name);
    Quiz findByFormationId(Long formationId);
    Quiz findByQuestionsId(Long questionId);

}
