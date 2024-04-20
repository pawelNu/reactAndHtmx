package com.pawelnu.reactandhtmx.controller.rest;

import com.pawelnu.reactandhtmx.entity.Task;
import com.pawelnu.reactandhtmx.repository.TaskRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks")
@AllArgsConstructor
public class TaskController {

  private TaskRepository taskRepository;

  @GetMapping
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    Task task = taskRepository.findById(id).orElse(null);
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(task, HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Task savedTask = taskRepository.save(task);
    return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
    Task task = taskRepository.findById(id).orElse(null);
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    task.setName(taskDetails.getName());
    task.setSubTasks(taskDetails.getSubTasks());
    Task updatedTask = taskRepository.save(task);
    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
    taskRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
