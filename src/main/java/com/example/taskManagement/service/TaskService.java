package com.example.taskManagement.service;

import com.example.taskManagement.dto.TaskResponse;
import com.example.taskManagement.exception.ResourceNotFoundException;
import com.example.taskManagement.model.Task;
import com.example.taskManagement.repository.TaskRepository;
import jakarta.annotation.Resource;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
//        if(task != null) {
//            // set created and updated timestamp
//            task.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
//            task.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
//        }
        return taskRepository.save(task);
    }

    public TaskResponse getAllTask() {
        TaskResponse taskResponse = new TaskResponse();
        List<Task> taskList = taskRepository.findAll();
        //return taskRepository.findAll();
        if(!taskList.isEmpty()) {
            taskResponse.setTaskCount(taskList.size());
            taskResponse.setResponseMessage("Total " + taskResponse.getTaskCount() +  " tasks found");
            taskResponse.setTaskList(taskList);
        } else {
            taskResponse.setResponseMessage("No tasks found!");
        }
        return taskResponse;
    }

    public List<Task> getByTaskPriority(String taskPriority){
        return taskRepository.findByTaskPriority(taskPriority);
    }

    public TaskResponse getByTaskStatus(String taskStatus) {

        TaskResponse taskResponse = new TaskResponse();

        List<Task> taskList = taskRepository.findByTaskStatus(taskStatus);
        if(!taskList.isEmpty()) {
            taskResponse.setTaskCount(taskList.size());
            taskResponse.setResponseMessage("Total - " + taskResponse.getTaskCount() + " tasks found");
            taskResponse.setTaskList(taskList);

            return taskResponse;
        }

        taskResponse.setResponseMessage("No tasks found!");
        return taskResponse;
    }

    public List<Task> getByTitle(String title){
        return taskRepository.findByTitle(title);
    }

    public Task getById(String userId){
        return taskRepository.findById(userId).orElse(null);
    }


}
