package com.hardi.SprintBack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String totalPoints;
	
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<Task> tasks = new ArrayList<Task>();

	public Sprint() {
	}

	public Sprint(String name, String totalPoints, List<Task> tasks) {
		this.name = name;
		this.totalPoints = totalPoints;
		this.tasks = tasks;
	}

	public Sprint(Long id, String name, String totalPoints, List<Task> tasks) {
		this.id = id;
		this.name = name;
		this.totalPoints = totalPoints;
		this.tasks = tasks;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
		Sprint other = (Sprint) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sprint [id=" + id + ", name=" + name + ", totalPoints=" + totalPoints;
	}
	
	public void deleteTask(Long id) {
		for(Task task : this.tasks) {
			if(task.getId() == id) {
				this.tasks.remove(task);
				return;
			}
		}
		return;
	}
	
}
