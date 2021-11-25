package com.hardi.SprintBack.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.State;
import com.hardi.SprintBack.web.dto.StateDTO;

@Component
public class StateToStateDTO implements Converter<State, StateDTO> {

	@Override
	public StateDTO convert(State source) {
		StateDTO dto = new StateDTO();
		dto.setId(source.getId());
		dto.setName(source.getName());
		return dto;
	}
	
	public List<StateDTO> convert(List<State> list){
		List<StateDTO> dto = new ArrayList<StateDTO>();
		for(State state : list) {
			dto.add(convert(state));
		}
		return dto;
	}

}
