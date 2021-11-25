package com.hardi.SprintBack.service;

import org.springframework.data.domain.Page;

import com.hardi.SprintBack.model.Task;
import com.hardi.SprintBack.web.dto.TaskDTO;

public interface TaskService {

	Page<Task> getAll(String name, Long sprintId, int pageNo);
	
	Task getOne(Long id);
	
	Task save(TaskDTO task);
	
	Task delete(Long id);
	
	Task changeState(Long id);
	
	Long sum (Long sprintId);
}
