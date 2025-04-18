package com.learn.hub.repositories;

import com.learn.hub.models.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

    Optional<Reponse> findById(Long Id);
    Reponse findByQuestionId(Long Id);
    List<Reponse> findByIstrue(Boolean isTrue);
}
