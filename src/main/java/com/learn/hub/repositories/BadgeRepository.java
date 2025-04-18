package com.learn.hub.repositories;

import com.learn.hub.models.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

    Optional<Badge> findById(Long Id);
    List<Badge> findByName(String name);
    List<Badge> findByNameContaining(String name);
    Badge findByFormationId(Long formationId);
    List<Badge> findByUsersId(Long studentId);

}
