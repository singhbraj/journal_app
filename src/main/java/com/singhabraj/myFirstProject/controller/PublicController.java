package com.singhabraj.myFirstProject.controller;

import com.singhabraj.myFirstProject.entity.User;
import com.singhabraj.myFirstProject.service.UserDetailsServiceImpl;
import com.singhabraj.myFirstProject.service.UserService;
import com.singhabraj.myFirstProject.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private UserService userService;

    @Autowired
   private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTutil jwTutil;

    @GetMapping("/health-check")
    public String heathCheck(){
        return "Ok";
    }

    @PostMapping("/signup")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }


    @PostMapping("/login")
    public void login(@RequestBody User user) {
         try{
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
             UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
         }catch(Exception e){

         }
    }

}



