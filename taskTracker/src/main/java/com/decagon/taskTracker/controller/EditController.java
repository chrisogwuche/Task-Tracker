package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.serviceImpl.TaskImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class EditController {

    @Autowired
    TaskImpl taskImpl;

    @GetMapping("/in-progress")
    public String MoveToInProgress(@RequestParam("id") String id){
        taskImpl.taskToInProgress(id);
        return "redirect:/";
    }

    @GetMapping("/completed")
    public String moveToCompleted(@RequestParam("id") String id){
        taskImpl.taskToCompleted(id);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") String id){
        taskImpl.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/pending")
    public String pending(@RequestParam("id") String id){
        taskImpl.pendingTask(id);
        return "redirect:/";
    }

//    @GetMapping("/edit")
//    public String editTask(@RequestParam("id") String id, Model model){
//        if(taskImpl.getTask(id)!=null){
//            model.addAttribute("editTask",taskImpl.getTask(id));
//        }
//        return "/add";
//    }
}
