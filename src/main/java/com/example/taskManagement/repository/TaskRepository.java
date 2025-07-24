package com.example.taskManagement.repository;

import com.example.taskManagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String>{
    List<Task> findByPriority(String priority);
    List<Task> findByStatus(String status);
    List<Task> findByTitle(String title);

}
