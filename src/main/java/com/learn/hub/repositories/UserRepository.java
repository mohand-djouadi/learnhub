package com.learn.hub.repositories;

import com.learn.hub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long Id);
    List<User> findByFirstname(String fname);
    List<User> findByFirstnameContaining(String fname);
    List<User> findByLastname(String lname);
    List<User> findByLastnameContaining(String lname);
    User findByEmail(String email);
    List<User> findByBadgesId(Long badgeId);
    List<User> findByInscriptionsFormationId(Long formId);

}
