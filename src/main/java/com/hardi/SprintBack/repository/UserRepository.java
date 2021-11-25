package com.hardi.SprintBack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardi.SprintBack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByUserName(String username);

    Optional<User> findFirstByUserNameAndPassword(String userName, String password);

    User findOneById(Long id);
}
