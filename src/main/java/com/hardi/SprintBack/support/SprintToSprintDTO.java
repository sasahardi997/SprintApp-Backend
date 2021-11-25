package com.hardi.SprintBack.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.Sprint;
import com.hardi.SprintBack.web.dto.SprintDTO;

@Component
public class SprintToSprintDTO implements Converter<Sprint, SprintDTO> {

	@Override
	public SprintDTO convert(Sprint source) {
		SprintDTO dto = new SprintDTO();
		dto.setId(source.getId());
		dto.setName(source.getName());
		dto.setTotalPoints(source.getTotalPoints());
		
		return dto;
	}
	
	public List<SprintDTO> convert(List<Sprint> list){
		List<SprintDTO> dto = new ArrayList<>();
		for(Sprint sprint : list) {
			dto.add(convert(sprint));
		}
		
		return dto;
	}

}
