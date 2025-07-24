package com.example.taskManagement.controller;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetByStatusController {
    private TaskService taskService;
    public GetByStatusController(TaskService taskService){
        this.taskService=taskService;

    }
    @GetMapping("/status/{status}")

    public List<Task> getByStatus(@PathVariable String status){
        return taskService.getByTaskStatus(status);

    }
}
