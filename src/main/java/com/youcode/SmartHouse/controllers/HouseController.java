package com.youcode.SmartHouse.controllers;

import com.youcode.SmartHouse.models.House;
import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.services.HouseService;
import com.youcode.SmartHouse.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("smarthouse/houses")
public class HouseController {

    @Autowired
    private  final HouseService houseService;
    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> fetchAllUsers(){
        List<House> houses = houseService.getAllHouses();
        if (houses.size() > 0) {
            return new ResponseEntity<List<House>>(houses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No house is available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchHouseById(@PathVariable("id") String id){
        House house = houseService.getHouseById(id);
        if (house != null) {
            return new ResponseEntity<>(house, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No house is available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHouse(@RequestBody House house){

        User getUserData = userService.findById(house.getUser().getUserId());

        if(getUserData == null){
            return new ResponseEntity<>(house, HttpStatus.NOT_FOUND);
        }
        house.setUser(getUserData);
        houseService.addHouse(house);
        return new ResponseEntity<>("House added", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateHouse(@RequestBody House house) {
        try {
            houseService.updateHouse(house);
            return new ResponseEntity<House>(house, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHouse(@PathVariable("id") String id) {
        try {
            houseService.deleteHouse(id);
            return new ResponseEntity<String>("House with id: "+id+" is deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

