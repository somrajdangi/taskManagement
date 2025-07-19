package com.example.taskManagement.service;

import com.example.taskManagement.model.Task;
import com.example.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
public Task saveTask(Task task){
    return taskRepository.save(task);

}

}
