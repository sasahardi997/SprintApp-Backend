package com.hardi.SprintBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardi.SprintBack.model.State;
import com.hardi.SprintBack.repository.StateRepository;
import com.hardi.SprintBack.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<State> getAll() {
		return stateRepository.findAll();
	}

	@Override
	public State getOne(Long id) {
		return stateRepository.findOneById(id);
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

}
