package com.example.taskManagement.service;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(task != null) {
            // set created and updated timestamp
            task.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
            task.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
        }
        return taskRepository.save(task);
    }
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    public List<Task> getByTaskPriority(String taskPriority){
        return taskRepository.findByTaskPriority(taskPriority);
    }
    public List<Task> getByTaskStatus(String taskStatus){
        return taskRepository.findByTaskStatus(taskStatus);
    }
    public List<Task> getByTitle(String title){
        return taskRepository.findByTitle(title);
    }
    public Task getById(String userId){
        return taskRepository.findById(userId).orElse(null);
    }


}
