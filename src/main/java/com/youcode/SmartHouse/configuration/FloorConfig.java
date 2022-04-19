package com.youcode.SmartHouse.configuration;


import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.repositories.FloorRepository;
import com.youcode.SmartHouse.repositories.HouseRepository;
import com.youcode.SmartHouse.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class FloorConfig {

/*    @Bean
    CommandLineRunner floorRunner(FloorRepository floorRepository, RoomRepository roomRepository, HouseRepository houseRepository) {
        return args -> {
            Floor floor = new Floor(
                    1L,
                    "Floor 1",
                    roomRepository.findAll(),
                    houseRepository.findById(1L).get()
            );

            List<Floor> floors = floorRepository.findAll();

            if (floors.isEmpty()) {
                System.out.println("Inserting floor: " + floor.getFloor());
                floorRepository.insert(floor);
            }
            if (floors.size() > 1) {
                throw new IllegalStateException("There is already a floor with this name");
            }
        };
    }*/
}
