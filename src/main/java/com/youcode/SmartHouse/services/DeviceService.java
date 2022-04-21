package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.Device;
import com.youcode.SmartHouse.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    @Autowired
    private  final DeviceRepository deviceRepository;

    public List<Device> getAllDevices(){
        return this.deviceRepository.findAll();
    }

    public Device getDeviceById(String id) {
        return this.deviceRepository.findById(id).orElse(null);
    }

    public void addDevice(Device device) {
        this.deviceRepository.save(device);
    }

    public void updateDevice(Device device) {
        this.deviceRepository.save(device);
    }

    public void deleteDevice(String id) {
        this.deviceRepository.deleteById(id);
    }


}
