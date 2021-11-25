package com.hardi.SprintBack.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.Task;
import com.hardi.SprintBack.web.dto.TaskDTO;

@Component
public class TaskToTaskDTO implements Converter<Task, TaskDTO> {

	@Override
	public TaskDTO convert(Task source) {
		TaskDTO dto = new TaskDTO();
		dto.setId(source.getId());
		dto.setIndepted(source.getIndebted());
		dto.setName(source.getName());
		dto.setPoints(source.getPoints());
		dto.setSprintId(source.getSprint().getId());
		dto.setSprintName(source.getSprint().getName());
		dto.setStateId(source.getState().getId());
		dto.setStateName(source.getState().getName());
		
		return dto;
	}

	public List<TaskDTO> convert(List<Task> list){
		List<TaskDTO> dto = new ArrayList<TaskDTO>();
		for(Task task : list) {
			dto.add(convert(task));
		}
		return dto;
	}
}
