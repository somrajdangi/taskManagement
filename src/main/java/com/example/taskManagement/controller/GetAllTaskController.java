package com.example.taskManagement.controller;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetAllTaskController {
    private  TaskService taskService;
    @Autowired
    public GetAllTaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/all")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }
}
