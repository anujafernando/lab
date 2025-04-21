package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Login;
import com.example.demo.service.LoginService;

@Controller

public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping("/")
    public String login() {
        return "login"; 
    }

    @GetMapping("/index")
    public String index() {
        return "index"; 
    }

    @PostMapping("/login")
    public String ProcessLogin(@RequestParam String username, @RequestParam String password) {
        
        Login user = service.log(username,password);
        if (user != null) {
            
            return "redirect:/index";
        } 
        else {
            
            return "redirect:/login";
         }

}
}
