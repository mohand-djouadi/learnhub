package com.learn.hub.repositories;

import com.learn.hub.models.Inscriptions;
import com.learn.hub.models.InscriptionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscriptions, InscriptionsId> {

    Optional<Inscriptions> findById(InscriptionsId Id);
    Inscriptions findByFormationId(Long formId);
    Inscriptions findByUserId(Long studentId);
    Inscriptions findByCourId(Long courId);

}
