package com.pawelnu.reactandhtmx.data;

import com.pawelnu.reactandhtmx.entity.SubTask;
import com.pawelnu.reactandhtmx.entity.Task;
import com.pawelnu.reactandhtmx.repository.SubTaskRepository;
import com.pawelnu.reactandhtmx.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

  private final TaskRepository taskRepository;
  private final SubTaskRepository subTaskRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    loadTestData();
  }

  private void loadTestData() {
    List<Task> tasks = generateTasks(25);

    for (Task task : tasks) {
      taskRepository.save(task);
    }

    List<SubTask> subTasks = generateSubTasks(100);

    Random random = new Random();
    for (SubTask subTask : subTasks) {
      Task randomTask = tasks.get(random.nextInt(tasks.size()));
      subTask.setTask(randomTask);
      subTaskRepository.save(subTask);
    }
  }

  private List<Task> generateTasks(int count) {
    List<Task> tasks = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      Task task = Task.builder()
                    .name("Przykładowe zadanie " + (i + 1))
                    .subTasks(new ArrayList<>())
                    .build();
      tasks.add(task);
    }
    return tasks;
  }

  private List<SubTask> generateSubTasks(int count) {
    List<SubTask> subTasks = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      SubTask subTask = SubTask.builder()
                          .name("Podzadanie " + (i + 1))
                          .build();
      subTasks.add(subTask);
    }
    return subTasks;
  }
}