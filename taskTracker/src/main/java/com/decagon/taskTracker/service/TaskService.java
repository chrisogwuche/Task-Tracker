package com.decagon.taskTracker.service;

import com.decagon.taskTracker.entity.UserTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    String saveTask(UserTask userTask);

    List<UserTask> getPendingTask();
    List<UserTask> getInProgressTask();
    List<UserTask> getCompletedTask();

    List<UserTask> getAllTask();

    void taskToInProgress(String id);

    void taskToCompleted(String id);

    void deleteTask(String id);

    void pendingTask(String id);

    UserTask getTask(String id);
}
