package com.pawelnu.reactandhtmx.controller.rest;

import com.pawelnu.reactandhtmx.entity.SubTask;
import com.pawelnu.reactandhtmx.repository.SubTaskRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtasks")
@Tag(name = "SubTasks")
@AllArgsConstructor
public class SubTaskController {

  private SubTaskRepository subTaskRepository;

  @GetMapping
  public List<SubTask> getAllSubTasks() {
    return subTaskRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubTask> getSubTaskById(@PathVariable Long id) {
    SubTask subTask = subTaskRepository.findById(id).orElse(null);
    if (subTask == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(subTask, HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity<SubTask> createSubTask(@RequestBody SubTask subTask) {
    SubTask savedSubTask = subTaskRepository.save(subTask);
    return new ResponseEntity<>(savedSubTask, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SubTask> updateSubTask(@PathVariable Long id, @RequestBody SubTask subTaskDetails) {
    SubTask subTask = subTaskRepository.findById(id).orElse(null);
    if (subTask == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    subTask.setName(subTaskDetails.getName());
    subTask.setTask(subTaskDetails.getTask());
    SubTask updatedSubTask = subTaskRepository.save(subTask);
    return new ResponseEntity<>(updatedSubTask, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteSubTask(@PathVariable Long id) {
    subTaskRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
