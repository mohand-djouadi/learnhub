package com.learn.hub.repositories;

import com.learn.hub.models.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourRepository extends JpaRepository<Cour, Long> {

    List<Cour> findAll();
    Optional<Cour> findById(Long Id);
    List<Cour> findByTitle(String title);
    List<Cour> findByTitleContaining(String title);
    Cour findByUrl(String url);
    List<Cour> findByFormationId(Long fomrationId);
    List<Cour> findByInscpritonUserId(Long studentId);
    List<Cour> findByFormationProfId(Long profId);
}
