package com.hardi.SprintBack.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.SprintBack.model.Sprint;
import com.hardi.SprintBack.service.SprintService;
import com.hardi.SprintBack.support.SprintToSprintDTO;
import com.hardi.SprintBack.web.dto.SprintDTO;

@RestController
@RequestMapping(value = "/api/sprints", produces = MediaType.APPLICATION_JSON_VALUE)
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private SprintToSprintDTO toDto;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<SprintDTO>> getAll(){
		
		List<Sprint> sprints = sprintService.getAll();
		
		return new ResponseEntity<List<SprintDTO>>(toDto.convert(sprints), HttpStatus.OK);
	}
}
