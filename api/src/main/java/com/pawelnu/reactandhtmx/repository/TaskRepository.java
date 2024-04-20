package com.pawelnu.reactandhtmx.repository;

import com.pawelnu.reactandhtmx.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
