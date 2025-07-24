package com.example.taskManagement.controller;

import com.example.taskManagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.taskManagement.model.Task;
@RestController
public class SaveTaskController {


    private final TaskService taskService;

    @Autowired
    public SaveTaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/task")
    public Task createTask(@RequestBody @Valid Task task){
          return taskService.saveTask(task);
    }

}
