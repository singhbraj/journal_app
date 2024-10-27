package com.singhabraj.myFirstProject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EmailServiceTest {

   @Autowired
    private  EmailService emailService;

   @Test
    void testSendMail(){
       emailService.sendEMail("braj333singh@gmail.com","Testing java mail sender","Hi Aap kese ho");
   }

}
