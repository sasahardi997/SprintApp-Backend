package com.hardi.SprintBack.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hardi.SprintBack.enumeration.UserRole;
import com.hardi.SprintBack.model.User;
import com.hardi.SprintBack.repository.UserRepository;
import com.hardi.SprintBack.service.UserService;

@Service
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User findOne(Long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(int pageNo) {
        return userRepository.findAll(PageRequest.of(pageNo, 10));
    }

    @Override
    public User save(User user) {
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findFirstByUserName(userName);
    }
}
