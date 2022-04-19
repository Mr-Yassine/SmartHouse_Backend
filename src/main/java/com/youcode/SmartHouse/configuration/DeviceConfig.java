package com.youcode.SmartHouse.configuration;

import com.youcode.SmartHouse.models.Device;
import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.repositories.DeviceRepository;
import com.youcode.SmartHouse.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class DeviceConfig {

/*    @Bean
    CommandLineRunner deviceRunner(DeviceRepository deviceRepository, RoomRepository roomRepository) {
        return args -> {
            Device device = new Device(
                    1L,
                    "TV",
                    roomRepository.findById(1L).get()
            );
            deviceRepository.insert(device);

            List<Device> devices = deviceRepository.findAll();

            if (devices.isEmpty()) {
                System.out.println("Inserting device " + device.getDevice());
                deviceRepository.insert(device);
            }
            if (devices.size() > 1) {
                throw new IllegalStateException("There is already a device with this name");
            }
        };
    }*/
}
