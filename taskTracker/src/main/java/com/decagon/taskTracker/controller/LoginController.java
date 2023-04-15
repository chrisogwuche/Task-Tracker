package com.decagon.taskTracker.controller;

import com.decagon.taskTracker.dto.UserDTO;
import com.decagon.taskTracker.serviceImpl.UserImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UserImpl userImpl;
    @Autowired
    private HttpServletRequest request;


    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("userDto",new UserDTO());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session){
        boolean auth = userImpl.authUser(userDTO);
        if(auth){
            session.setAttribute("name",userDTO.getEmail());
            return "redirect:/index";
        }
        else{
            return "redirect:/";
        }

    }
}
