package com.hardi.SprintBack.service;

import java.util.List;

import com.hardi.SprintBack.model.Sprint;

public interface SprintService {

	List<Sprint> getAll();
	
	Sprint getOne(Long id);
	
	Sprint save(Sprint sprint);
}
