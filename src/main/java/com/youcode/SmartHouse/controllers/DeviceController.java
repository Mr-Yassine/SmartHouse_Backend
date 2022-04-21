package com.youcode.SmartHouse.controllers;

import com.youcode.SmartHouse.models.Device;
import com.youcode.SmartHouse.models.User;
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
    public ResponseEntity<?> fetchDeviceById(@PathVariable("id") String id){
        Device device = deviceService.getDeviceById(id);
        if (device != null) {
            return new ResponseEntity<Device>(device, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDevice(@RequestBody Device device){
        try {
            deviceService.addDevice(device);
            return new ResponseEntity<Device>(device, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDevice(@RequestBody Device device){
        try {
            deviceService.updateDevice(device);
            return new ResponseEntity<Device>(device, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable("id") String id){
        try {
            deviceService.deleteDevice(id);
            return new ResponseEntity<String>("Device with id: "+id+" is deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No device is available", HttpStatus.NOT_FOUND);
        }
    }
}
