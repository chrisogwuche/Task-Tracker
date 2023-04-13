package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.dto.UserTaskDto;
import com.decagon.taskTracker.entity.UserTask;
import com.decagon.taskTracker.serviceImpl.TaskImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class indexController {

    @Autowired
    private TaskImpl addTaskImpl;


    @GetMapping("/")
    public String goToIndex(Model model){
        model.addAttribute("userTaskDto", new UserTaskDto());
        model.addAttribute("pendingTask", getPendingTask());
        model.addAttribute("inProgressTask", getInProgressTask());
        model.addAttribute("completedTask", getCompletedTask());
        model.addAttribute("allTask", getAllTask());

        return "index";
    }


    @PostMapping("/add-task")
    public String addTask(@ModelAttribute UserTaskDto userTaskDto, Model model){
        if(userTaskDto.getTitle().isEmpty()){
           return"redirect:/";
        }
        UserTask userTask = new UserTask(userTaskDto.getTitle(), userTaskDto.getDescription());
        log.info("i am save status: " +addTaskImpl.saveTask(userTask));
        model.addAttribute("status",addTaskImpl.saveTask(userTask));
        return "redirect:/";
    }


    private List<UserTaskDto> getPendingTask(){
        List<UserTaskDto> userDtoList = new ArrayList<>();
        for(UserTask task: addTaskImpl.getPendingTask()){
            userDtoList
                    .add(new UserTaskDto(task.getId().toString(),task.getTitle(),task.getDescription(),task.getStatus()
                            ,task.getCreatedAT()));
        }
        return userDtoList;
    }


    private List<UserTaskDto> getInProgressTask(){
        List<UserTaskDto> userDtoList = new ArrayList<>();
        for(UserTask task: addTaskImpl.getInProgressTask()){
            userDtoList
                    .add(new UserTaskDto(task.getId().toString(),task.getTitle(),task.getDescription(),task.getStatus()
                            ,task.getCreatedAT()));
        }

        return userDtoList;
    }


    private List<UserTaskDto> getCompletedTask(){
        List<UserTaskDto> userDtoList = new ArrayList<>();
        for(UserTask task: addTaskImpl.getCompletedTask()){
            userDtoList
                    .add(new UserTaskDto(task.getId().toString(),task.getTitle(),task.getDescription(),task.getStatus()
                            ,task.getCreatedAT()));
        }
        return userDtoList;
    }


    @Bean
    private List<UserTaskDto> getAllTask(){
        List<UserTaskDto> userDtoList = new ArrayList<>();
        for(UserTask task: addTaskImpl.getAllTask()){
            userDtoList
                    .add(new UserTaskDto(task.getId().toString(),task.getTitle(),task.getDescription(),task.getStatus()
                            ,task.getCreatedAT()));
        }
        return userDtoList;
    }
}
