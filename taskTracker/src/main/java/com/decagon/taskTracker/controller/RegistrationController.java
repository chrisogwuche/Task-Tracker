package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.dto.UserDTO;
import com.decagon.taskTracker.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserImpl userImpl;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userDto", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute UserDTO userDTO){
        userImpl.saveUser(userDTO);
        return "redirect:/";
    }
}
