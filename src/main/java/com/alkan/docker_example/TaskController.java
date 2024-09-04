package com.alkan.docker_example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void save(@RequestBody Task task) throws Exception {
        var isExist = taskRepository.findByName(task.getName());
        if (isExist.isPresent()) {
            throw new Exception("Task is already exist");
        }
        taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Task updatedTask) throws Exception {
        var task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            taskRepository.save(task);
        }
    }

}
