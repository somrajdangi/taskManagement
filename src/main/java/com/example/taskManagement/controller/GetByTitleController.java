package com.example.taskManagement.controller;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetByTitleController {
   private TaskService taskService;
   GetByTitleController(TaskService taskService){
       this.taskService=taskService;
   }
   @GetMapping("/title/{title}")
    public List<Task> getByTitle(@PathVariable String title){
       return taskService.getByTitle(title);
   }

}
