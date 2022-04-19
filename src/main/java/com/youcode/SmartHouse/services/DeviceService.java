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

    public Device addDevice(Device device) {
        return null;
    }

    public Device updateDevice(Device device) {
        return null;
    }

    public Device deleteDevice(Long id) {
        return null;
    }

    public Device getDeviceById(Long id) {
        return null;
    }
}
