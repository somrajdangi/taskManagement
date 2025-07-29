package com.example.taskManagement.controller;

import com.example.taskManagement.dto.TaskResponse;
import com.example.taskManagement.model.Task;
import com.example.taskManagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path ="save")
    public Task createTask(@RequestBody @Valid Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/getAll")
    public TaskResponse getAllTask(){
        return taskService.getAllTask();
    }

//    @GetMapping("/status/{status}")
//    public List<Task> getByStatus(@PathVariable String status) {
//        return taskService.getByTaskStatus(status);
//    }

    @GetMapping("/status/{status}")
    public ResponseEntity<TaskResponse> getByStatus(@PathVariable String status) {
        TaskResponse taskResponse = taskService.getByTaskStatus(status);
        if(taskResponse.getTaskCount() == 0) {
            return new ResponseEntity<TaskResponse>(taskResponse, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<TaskResponse>(taskResponse, HttpStatus.OK);
        }

}

    @GetMapping("/priority/{taskPriority}")
    public List<Task> getByTaskPriority(@PathVariable String taskPriority){
        return taskService.getByTaskPriority(taskPriority);
    }

    @GetMapping("/title/{title}")
    public List<Task> getByTitle(@PathVariable String title){
        return taskService.getByTitle(title);
    }

    @GetMapping("/id/{userId}")
    public Task getByUserId(@PathVariable String userId){
        return taskService.getById(userId);
    }
}
