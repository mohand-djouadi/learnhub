package com.learn.hub.repositories;

import com.learn.hub.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    List<Formation> findAll();
    Optional<Formation> findById(Long Id);
    List<Formation> findByProfId(Long profId);
    List<Formation> findByTitle(String title);
    List<Formation> findByTitleContaining(String title);
    Formation findByCoursId(Long courId);
    List<Formation> findByQuizId(Long quizId);
    List<Formation> findByInscriptionsUserId(Long studentId);
    List<Formation> findByPremium(Boolean premium);

}
