package com.hardi.SprintBack.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.hardi.SprintBack.model.State;

@Repository
public interface StateRepository extends JpaRepositoryImplementation<State, Long> {

	State findOneById(Long id);
}
