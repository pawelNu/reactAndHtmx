package com.pawelnu.reactandhtmx.controller.view;

import com.pawelnu.reactandhtmx.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/tasks")
@AllArgsConstructor
public class TaskViewController {

  private TaskRepository taskRepository;

  @RequestMapping("")
  public String getAllTasks() {
    return "index";
  }

//  @GetMapping("/{id}")
//  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//    Task task = taskRepository.findById(id).orElse(null);
//    if (task == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    } else {
//      return new ResponseEntity<>(task, HttpStatus.OK);
//    }
//  }
//
//  @PostMapping
//  public ResponseEntity<Task> createTask(@RequestBody Task task) {
//    Task savedTask = taskRepository.save(task);
//    return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
//  }
//
//  @PutMapping("/{id}")
//  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//    Task task = taskRepository.findById(id).orElse(null);
//    if (task == null) {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    task.setName(taskDetails.getName());
//    task.setSubTasks(taskDetails.getSubTasks());
//    Task updatedTask = taskRepository.save(task);
//    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
//  }
//
//  @DeleteMapping("/{id}")
//  public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
//    taskRepository.deleteById(id);
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//  }
}
