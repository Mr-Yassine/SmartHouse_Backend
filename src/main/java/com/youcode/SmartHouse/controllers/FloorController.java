package com.youcode.SmartHouse.controllers;

import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.services.FloorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("smarthouse/floors")
public class FloorController {

    private final FloorService floorService;

    @GetMapping
    public ResponseEntity<?> fetchAllFloors(){
        List<Floor> floors = floorService.getAllFloors();
        if (floors.size() > 0) {
            return new ResponseEntity<List<Floor>>(floors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No floor is available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchFloorById(Long id){
        Floor floor = floorService.getFloorById(id);
        if (floor != null) {
            return new ResponseEntity<Floor>(floor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No floor is available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addFloor(Floor floor){
        floorService.addFloor(floor);
        return new ResponseEntity<>("Floor added", HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateFloor(Floor floor){
        floorService.updateFloor(floor);
        return new ResponseEntity<>("Floor updated", HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteFloor(Long id){
        floorService.deleteFloor(id);
        return new ResponseEntity<>("Floor deleted", HttpStatus.OK);
    }
}
