package com.youcode.SmartHouse.configuration;

import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.models.House;
import com.youcode.SmartHouse.repositories.FloorRepository;
import com.youcode.SmartHouse.repositories.HouseRepository;
import com.youcode.SmartHouse.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;


@Configuration
public class HouseConfig {

    @Bean
    public CommandLineRunner house(HouseRepository houseRepository, FloorRepository floorRepository, UserRepository userRepository) {
        return args -> {
            List<House> houses = houseRepository.findAll();
            if (houses.isEmpty()) {
                House house = new House(
                        1L,
                        "House 1",
                        Collections.singletonList(floorRepository.findById(1L).get()),
                        userRepository.findById(1L).get()
                );
                System.out.println("Inserting house: " + house.getHouse());
                houseRepository.insert(house);
            }
            throw new IllegalStateException("There is already a house");
        };
    }
}
