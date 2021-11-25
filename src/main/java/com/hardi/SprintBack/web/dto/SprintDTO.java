package com.hardi.SprintBack.web.dto;

import javax.validation.constraints.Positive;

public class SprintDTO {

	@Positive(message = "Id can't be negative number.")
	private Long id;
	
	private String name;
	
	private String totalPoints;
	
	public SprintDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(String totalPoints) {
		this.totalPoints = totalPoints;
	}
	
}
