package com.decagon.taskTracker.serviceImpl;

import com.decagon.taskTracker.entity.UserTask;
import com.decagon.taskTracker.enums.Status;
import com.decagon.taskTracker.repository.TaskRepository;
import com.decagon.taskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskImpl implements TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Override
    public String saveTask(UserTask userTask) {
      List<UserTask> userTaskList = new ArrayList<>();
      userTaskList.add(taskRepository.save(userTask));
       if(!userTaskList.isEmpty()){
           return "success";
       }
      return "failed";
    }

    @Override
    public List<UserTask> getPendingTask() {
        return taskRepository.findByStatus(Status.PENDING);
    }

    @Override
    public List<UserTask> getInProgressTask() {
        return taskRepository.findByStatus(Status.IN_PROGRESS);
    }

    @Override
    public List<UserTask> getCompletedTask() {
        return taskRepository.findByStatus(Status.COMPLETED);
    }

    @Override
    public List<UserTask> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public void taskToInProgress(String id) {
        Long taskId = Long.valueOf(id);
        UserTask task;
        Optional<UserTask> optionalUserTask = taskRepository.findById(taskId);
        if(optionalUserTask.isPresent()){
            task = optionalUserTask.get();
            task.setStatus(Status.IN_PROGRESS);
            UserTask userTask = taskRepository.save(task);
        }
    }

    @Override
    public void taskToCompleted(String id) {
        Long taskId = Long.valueOf(id);
        UserTask task;
        Optional<UserTask> optionalUserTask = taskRepository.findById(taskId);
        if(optionalUserTask.isPresent()){
            task = optionalUserTask.get();
            task.setStatus(Status.COMPLETED);
            UserTask userTask = taskRepository.save(task);
        }
    }

    @Override
    public void deleteTask(String id) {
        Long taskId = Long.valueOf(id);
        UserTask task;
        Optional<UserTask> optionalUserTask = taskRepository.findById(taskId);
        if(optionalUserTask.isPresent()){
            taskRepository.deleteById(taskId);
        }
    }

    @Override
    public void pendingTask(String id) {
        Long taskId = Long.valueOf(id);
        UserTask task;
        Optional<UserTask> optionalUserTask = taskRepository.findById(taskId);
        if(optionalUserTask.isPresent()){
            task = optionalUserTask.get();
            task.setStatus(Status.PENDING);
            UserTask userTask = taskRepository.save(task);
        }
    }

    @Override
    public UserTask getTask(String id) {
        Long taskId = Long.valueOf(id);
        UserTask task = null;
        Optional<UserTask> optionalUserTask = taskRepository.findById(taskId);
        if(optionalUserTask.isPresent()){
            task = optionalUserTask.get();
        }
        return task;
    }
}
