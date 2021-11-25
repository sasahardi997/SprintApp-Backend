package com.hardi.SprintBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardi.SprintBack.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

	Sprint findOneByid(Long id);
}
