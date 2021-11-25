package com.hardi.SprintBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String indebted;
	
	@Column
	private Integer points;
	
	@ManyToOne
	private Sprint sprint;
	
	@ManyToOne
	private State state;

	public Task() {
	}

	public Task(String name, String indebted, Integer points, Sprint sprint, State state) {
		this.name = name;
		this.indebted = indebted;
		this.points = points;
		this.sprint = sprint;
		this.state = state;
	}

	public Task(Long id, String name, String indebted, Integer points, Sprint sprint, State state) {
		this.id = id;
		this.name = name;
		this.indebted = indebted;
		this.points = points;
		this.sprint = sprint;
		this.state = state;
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

	public String getIndebted() {
		return indebted;
	}

	public void setIndebted(String indebted) {
		this.indebted = indebted;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", indebted=" + indebted + ", points=" + points;
	}
	
}
