package com.youcode.SmartHouse.configuration;


import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.repositories.DeviceRepository;
import com.youcode.SmartHouse.repositories.FloorRepository;
import com.youcode.SmartHouse.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public class RoomConfig {
/*
    @Bean
    CommandLineRunner roomRunner(RoomRepository roomRepository, FloorRepository floorRepository, DeviceRepository deviceRepository) {
        return args -> {
            Room room = new Room(
                    1L,
                    "Bedroom",
                    deviceRepository.findAll()
            );

            List<Room> rooms = roomRepository.findAll();

            if (rooms.isEmpty()) {
                System.out.println("Inserting room: " + room.getRoom());
                roomRepository.insert(room);
            }
            if (rooms.size() > 1) {
                throw new IllegalStateException("There is already a room with this name");
            }
        };
    }*/
}
