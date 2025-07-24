package com.example.taskManagement.controller;

import com.example.taskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.taskManagement.model.Task;
import java.util.List;

@RestController
public class GetByTaskPriorityController {
    private TaskService taskService;
    @Autowired
    public GetByTaskPriorityController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/priority/{taskPriority}")
    public List<Task> getByTaskPriority(@PathVariable String taskPriority){
        return taskService.getByTaskPriority(taskPriority);
    }

}
