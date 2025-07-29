package com.example.taskManagement.dto;

import com.example.taskManagement.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class TaskResponse {

    private int taskCount;
    private String responseMessage;
    private List<Task> taskList;
}
