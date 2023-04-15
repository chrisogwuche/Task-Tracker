package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.serviceImpl.TaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EditController {

    @Autowired
    TaskImpl taskImpl;

    @GetMapping("/in-progress")
    public String MoveToInProgress(@RequestParam("id") String id){
        taskImpl.taskToInProgress(id);
        return "redirect:/index";
    }

    @GetMapping("/completed")
    public String moveToCompleted(@RequestParam("id") String id){
        taskImpl.taskToCompleted(id);
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") String id){
        taskImpl.deleteTask(id);
        return "redirect:/index";
    }
    @GetMapping("/pending")
    public String pending(@RequestParam("id") String id){
        taskImpl.pendingTask(id);
        return "redirect:/index";
    }

}
