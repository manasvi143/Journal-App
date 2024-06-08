package com.manasvi.Journal.App.controller;

import com.manasvi.Journal.App.entity.Users;
import com.manasvi.Journal.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String HealthCheck(){
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody Users user){
        userService.saveNewEntry(user);
    }
}
