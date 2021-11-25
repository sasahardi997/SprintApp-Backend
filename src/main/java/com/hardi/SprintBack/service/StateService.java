package com.hardi.SprintBack.service;

import java.util.List;

import com.hardi.SprintBack.model.State;

public interface StateService {

	List<State> getAll();
	
	State getOne(Long id);
	
	State save(State state);
}
