package com.singhabraj.myFirstProject.controller;

import com.singhabraj.myFirstProject.entity.User;
import com.singhabraj.myFirstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private UserService userService;


    @GetMapping("/health-check")
    public String heathCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }




}



