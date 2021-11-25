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

import com.hardi.SprintBack.model.State;
import com.hardi.SprintBack.service.StateService;
import com.hardi.SprintBack.support.StateToStateDTO;
import com.hardi.SprintBack.web.dto.StateDTO;

@RestController
@RequestMapping(value = "/api/states", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private StateToStateDTO toDto;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'KORISNIK')")
	@GetMapping
	public ResponseEntity<List<StateDTO>> getAll(){
		
		List<State> states = stateService.getAll();
		
		return new ResponseEntity<List<StateDTO>>(toDto.convert(states), HttpStatus.OK);
	}
}
