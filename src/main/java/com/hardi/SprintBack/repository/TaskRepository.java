package com.hardi.SprintBack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hardi.SprintBack.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findOneById(Long id);
	
	@Query("SELECT t FROM Task t WHERE " + 
			"(:name = NULL OR t.name LIKE %:name%) AND " +
			"(:sprintId = NULL OR t.sprint.id = :sprintId)" +
			" ORDER BY t.points DESC")
	Page<Task> search(
			@Param("name") String name,
			@Param("sprintId") Long id,
			Pageable pageable);
	
	@Query("SELECT COALESCE(SUM(t.points), 0) FROM Task t WHERE t.sprint.id = :sprintId")
	Long sum(Long sprintId);
}
