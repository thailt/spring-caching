package com.egs.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.egs.entity.User;
import com.egs.service.UserService;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    UserService userService;

    @Override
    public void run(String... arg0) throws Exception {
        User user = new User();
        user.setEmail("thai1225@gmail.com");
        user.setName("le tri thai");

        long beginSave = System.nanoTime();
        for (long i = 0; i < 100; i++) {
            user.setId(i);
            userService.save(user);
        }
        long endSave = System.nanoTime();

        long beginFind = System.nanoTime();
        for (long i = 0; i < 1000; i++) {
            
            User userFound = userService.find(425991L);
        }
        long endFind = System.nanoTime();

        logger.info("end forloop , take {}", (endFind - beginFind) / 1000000.0);
    }

}
