package com.hardi.SprintBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardi.SprintBack.model.Sprint;
import com.hardi.SprintBack.repository.SprintRepository;
import com.hardi.SprintBack.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;
	
	@Override
	public List<Sprint> getAll() {
		return sprintRepository.findAll();
	}

	@Override
	public Sprint getOne(Long id) {
		return sprintRepository.findOneByid(id);
	}

	@Override
	public Sprint save(Sprint sprint) {
		return sprintRepository.save(sprint);
	}

}
