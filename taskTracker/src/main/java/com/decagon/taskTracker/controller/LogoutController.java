package com.decagon.taskTracker.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/logout")
    public String logout(){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
