package com.singhabraj.myFirstProject.controller;


import com.singhabraj.myFirstProject.api.response.WeatherAPIResponse;
import com.singhabraj.myFirstProject.entity.User;
import com.singhabraj.myFirstProject.repository.UserRepository;
import com.singhabraj.myFirstProject.service.UserService;
import com.singhabraj.myFirstProject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<User> getAllUsers(){
         return userService.getAll();
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
          userInDb.setUserName(user.getUserName());
          userInDb.setPassword(user.getPassword());
          userService.saveUser(userInDb);

      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        userRepository.deleteByUserName(userName);
        return null;
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherAPIResponse weatherAPIResponse = weatherService.getWeather("Aligarh");
        String greeting = "";
        if(weatherAPIResponse!=null){
            greeting  =  ", Weather feels like "+weatherAPIResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+ authentication.getName() +greeting,HttpStatus.OK);
    }

}
