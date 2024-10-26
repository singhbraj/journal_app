package com.singhabraj.myFirstProject.service;

import com.singhabraj.myFirstProject.repository.UserRepository;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UserDetailsServiceImpTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepository userRepository;

    void loadUserByUserNameTest(){
//        when(userRepository.findByUserName()).thenReturn()
        userDetailsService.loadUserByUsername("braj");

    }
}
