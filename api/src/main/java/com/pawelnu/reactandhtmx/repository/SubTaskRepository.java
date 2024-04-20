package com.pawelnu.reactandhtmx.repository;

import com.pawelnu.reactandhtmx.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
