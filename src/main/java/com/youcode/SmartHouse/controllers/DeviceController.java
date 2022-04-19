package com.youcode.SmartHouse.controllers;

import com.youcode.SmartHouse.models.Device;
import com.youcode.SmartHouse.services.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("smarthouse/devices")
public class DeviceController {

    private  final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<?> fetchAllDevices(){
        List<Device> devices = deviceService.getAllDevices();
        if (devices.size() > 0) {
            return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> fetchDeviceById(Long id){
        Device device = deviceService.getDeviceById(id);
        if (device != null) {
            return new ResponseEntity<Device>(device, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDevice(Device device){
        Device newDevice = deviceService.addDevice(device);
        if (newDevice != null) {
            return new ResponseEntity<Device>(newDevice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDevice(Device device){
        Device updatedDevice = deviceService.updateDevice(device);
        if (updatedDevice != null) {
            return new ResponseEntity<Device>(updatedDevice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDevice(Long id){
        Device deletedDevice = deviceService.deleteDevice(id);
        if (deletedDevice != null) {
            return new ResponseEntity<Device>(deletedDevice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }
}
