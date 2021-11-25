package com.hardi.SprintBack.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.Task;
import com.hardi.SprintBack.service.SprintService;
import com.hardi.SprintBack.service.StateService;
import com.hardi.SprintBack.service.TaskService;
import com.hardi.SprintBack.web.dto.TaskDTO;

@Component
public class TaskDtoToTask implements Converter<TaskDTO, Task> {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StateService stateService;
	
	@Override
	public Task convert(TaskDTO dto) {
		Task entity;
		
		if(dto.getId() == null) {
			entity = new Task();
		} else {
			entity = taskService.getOne(dto.getId());
		}
		
		if(entity != null) {
			entity.setId(dto.getId());
			entity.setIndebted(dto.getIndepted());
			entity.setName(dto.getName());
			entity.setPoints(dto.getPoints());
			entity.setSprint(sprintService.getOne(dto.getSprintId()));
			entity.setState(stateService.getOne(dto.getStateId()));
			
			return entity;
		}
		return null;
	}

}
