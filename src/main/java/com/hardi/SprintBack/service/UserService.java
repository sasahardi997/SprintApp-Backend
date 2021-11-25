package com.hardi.SprintBack.service;

import org.springframework.data.domain.Page;

import com.hardi.SprintBack.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findOne(Long id);

    List<User> findAll();

    Page<User> findAll(int pageNo);

    User save(User user);

    void delete(Long id);

    Optional<User> findByUserName(String userName);

}