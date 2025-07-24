package com.example.taskManagement.controller;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetByUserIdController {
    private TaskService taskService;
    GetByUserIdController(TaskService taskService){
        this.taskService=taskService;
    }
    @GetMapping("/id/{userId}")
    public Task getByUserId(@PathVariable String userId){
        return taskService.getById(userId);
    }
}
