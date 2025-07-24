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
    public List<Task> getByPriority(String priority){
        return taskRepository.findByPriority(priority);
    }
    public List<Task> getByStatus(String status){
        return taskRepository.findByStatus(status);
    }
    public List<Task> getByTitle(String title){
        return taskRepository.findByTitle(title);
    }
    public Task getById(String id){
        return taskRepository.findById(id).orElse(null);
    }


}
