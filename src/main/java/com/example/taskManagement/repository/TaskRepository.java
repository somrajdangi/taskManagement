package com.example.taskManagement.repository;

import com.example.taskManagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String>{
    List<Task> findByTaskPriority(String taskPriority);
    List<Task> findByTaskStatus(String taskStatus);
    List<Task> findByTitle(String title);

}
