package com.youcode.SmartHouse.configuration;


import com.youcode.SmartHouse.models.*;
import com.youcode.SmartHouse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UserConfig {


    @Bean
    CommandLineRunner userRunner(UserRepository userRepository, HouseRepository houseRepository) {

        return args -> {
            User user = new User(
                1L,
                "Yassine",
                "0612345678",
                "y@gmail.com",
                "123",
                LocalDateTime.now(),
                    houseRepository.findAll()
            );

            userRepository.findByEmail(user.getEmail())
                    .ifPresentOrElse(u -> {
                        System.out.println(u + " already exists");
                    }, () -> {
                        System.out.println("Inserting user " + user);
                        userRepository.insert(user);
                    });

        };
    }
}
