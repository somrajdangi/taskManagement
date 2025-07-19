package com.example.taskManagement.controller;

import com.example.taskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.taskManagement.model.Task;
@RestController
public class SaveTaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/task")
    public Task createTask(@RequestBody Task task){
          return  taskService.saveTask(task);
    }

}
