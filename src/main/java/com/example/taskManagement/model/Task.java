package com.example.taskManagement.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id; // id should be generated automatically

    @NotBlank
    private String title;
    private String description;
    private boolean active;
    private String userId;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
