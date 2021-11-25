package com.hardi.SprintBack.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class TaskDTO {

	@Positive(message = "Id can't be negative number.")
	private Long id;
	
	@NotBlank(message = "Task name can't be blank String.")
	@NonNull
	@Size(max = 40, message = "Number of characters can't be longer than 40.")
	private String name;
	
	private String indepted;
	
	@Min(value = 0, message = "Number of points must be between 0 and 20.")
	@Max(value = 20, message = "Number of points must be between 0 and 20.")
	private Integer points;
	
	private Long stateId;
	
	private String stateName;
	
	private Long sprintId;
	
	private String sprintName;
	
	public TaskDTO() {
		
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

	public String getIndepted() {
		return indepted;
	}

	public void setIndepted(String indepted) {
		this.indepted = indepted;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	
}
