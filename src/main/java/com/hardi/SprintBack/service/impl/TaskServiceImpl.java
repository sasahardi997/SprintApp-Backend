package com.hardi.SprintBack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hardi.SprintBack.model.Sprint;
import com.hardi.SprintBack.model.State;
import com.hardi.SprintBack.model.Task;
import com.hardi.SprintBack.repository.TaskRepository;
import com.hardi.SprintBack.service.SprintService;
import com.hardi.SprintBack.service.StateService;
import com.hardi.SprintBack.service.TaskService;
import com.hardi.SprintBack.support.TaskDtoToTask;
import com.hardi.SprintBack.web.dto.TaskDTO;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private TaskDtoToTask toTask;
	
	@Override
	public Page<Task> getAll(String name, Long sprintId, int pageNo) {
		return taskRepository.search(name, sprintId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Task getOne(Long id) {
		return taskRepository.findOneById(id);
	}

	@Override
	public Task save(TaskDTO dto) {
		Sprint sprint = sprintService.getOne(dto.getSprintId());
		
		if(dto.getId() == null) {
			//Create
			sprint.setTotalPoints(String.valueOf(Integer.parseInt(sprint.getTotalPoints()) + dto.getPoints()));
			sprintService.save(sprint);
			
			return taskRepository.save(toTask.convert(dto));
		} else {
			//Update
			Task oldTask = taskRepository.findOneById(dto.getId());
			Integer oldPoints = oldTask.getPoints();
			
			Task task = toTask.convert(dto);
			Integer newPoints = task.getPoints();
			
			sprint.setTotalPoints(String.valueOf(Integer.parseInt(sprint.getTotalPoints()) - oldPoints + newPoints));
			sprintService.save(sprint);
			
			return taskRepository.save(task);
		}
		
		
	}

	@Override
	public Task delete(Long id) {
		Task task = taskRepository.findOneById(id);
		
		if(task != null) {
			State state = task.getState();
			Sprint sprint = task.getSprint();
			
			state.deleteTask(id);
			stateService.save(state);
			
			sprint.deleteTask(id);
			sprint.setTotalPoints(String.valueOf(Integer.parseInt(sprint.getTotalPoints()) - task.getPoints()));
			sprintService.save(sprint);
			
			taskRepository.delete(task);
			return task;
		}
		return null;
	}

	@Override
	public Task changeState(Long id) {
		Task task = taskRepository.findOneById(id);
		
		if(task != null) {
			if(task.getState().getId() == 1) {
				task.setState(stateService.getOne(2L));
			}
			else if(task.getState().getId() == 2) {
				task.setState(stateService.getOne(3l));
			}
			taskRepository.save(task);
			return task;
		}
		return null;
	}

	@Override
	public Long sum(Long sprintId) {
		return taskRepository.sum(sprintId);
	}

}
