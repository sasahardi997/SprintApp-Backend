package com.hardi.SprintBack.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.SprintBack.support.TaskDtoToTask;
import com.hardi.SprintBack.support.TaskToTaskDTO;
import com.hardi.SprintBack.web.dto.TaskDTO;
import com.hardi.SprintBack.model.Task;
import com.hardi.SprintBack.service.TaskService;

@RestController
@RequestMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskToTaskDTO toDto;
	
	@Autowired
	private TaskDtoToTask toTask;
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAll(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Long sprintId,
			@RequestParam(value = "pageNo", defaultValue="0" ) int pageNo){
		
		
		Page<Task> tasks = taskService.getAll(name, sprintId, pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", String.valueOf(tasks.getTotalPages()));
		
		Long sum = 0L;
		if(sprintId != null) {
			sum = taskService.sum(sprintId);
		}
		headers.add("Sprint-Sum", String.valueOf(sum));
		
		return new ResponseEntity<List<TaskDTO>>(toDto.convert(tasks.getContent()), headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> getOne(@PathVariable Long id){
		
		Task task = taskService.getOne(id);
		
		return new ResponseEntity<TaskDTO>(toDto.convert(task), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskDTO> create(@Valid @RequestBody TaskDTO dto){
		
		Task created = taskService.save(dto);
		
		return new ResponseEntity<TaskDTO>(toDto.convert(created), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value="/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskDTO> update(@PathVariable Long id, @Valid @RequestBody TaskDTO dto){
		
		Task task = taskService.getOne(id);
		
		if(id != dto.getId()) {
			return new ResponseEntity<TaskDTO>(HttpStatus.BAD_REQUEST);
		} else if(task == null) {
			return new ResponseEntity<TaskDTO>(HttpStatus.NOT_FOUND);
		} 
		
//		Task updated = taskService.save(toTask.convert(dto));
		Task updated = taskService.save(dto);
		return new ResponseEntity<TaskDTO>(toDto.convert(updated), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping(value = "/change-state/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Long id){
		
		Task updated = taskService.changeState(id);
		
		return new ResponseEntity<TaskDTO>(toDto.convert(updated), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Task deleted = taskService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
}
