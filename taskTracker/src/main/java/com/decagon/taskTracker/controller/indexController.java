package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.dto.UserTaskDTO;
import com.decagon.taskTracker.entity.UserTask;
import com.decagon.taskTracker.serviceImpl.TaskImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class indexController {

    @Autowired
    private TaskImpl taskImpl;

    @GetMapping("/index")
    public String goToIndex(Model model){

        model.addAttribute("userTaskDto", new UserTaskDTO());

        model.addAttribute("pendingTask", taskImpl.getPendingTask());
        model.addAttribute("inProgressTask", taskImpl.getInProgressTask());
        model.addAttribute("completedTask", taskImpl.getCompletedTask());
        model.addAttribute("allTask", taskImpl.getAllTask());

        return "index";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute UserTaskDTO userTaskDto, Model model){
        if(userTaskDto.getTitle().isEmpty()){
           return"redirect:/index";
        }
        UserTask userTask = new UserTask(userTaskDto.getTitle(), userTaskDto.getDescription());
        model.addAttribute("status",taskImpl.saveTask(userTask));
        return "redirect:/index";
    }
}
