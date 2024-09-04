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

    @PostMapping
    public void save(@RequestBody Task task) throws Exception {
        var isExist = taskRepository.findByName(task.getName());
        if (isExist.isPresent()) {
            throw new Exception("Task is already exist");
        }
        taskRepository.save(task);
    }
}
