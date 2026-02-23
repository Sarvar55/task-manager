package org.task.taskmaganer.controller;

import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.taskmaganer.dto.request.CreateTaskRequest;
import org.task.taskmaganer.dto.response.TaskResponse;
import org.task.taskmaganer.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks", name = "TaskController")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Void> save(@RequestBody CreateTaskRequest request) {
        taskService.save(request);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
