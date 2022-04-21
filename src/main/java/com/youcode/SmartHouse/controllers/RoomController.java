package com.youcode.SmartHouse.controllers;

import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("smarthouse/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<?> fetchAllRooms(){
        List<Room> rooms = roomService.getAllRooms();
        if (rooms.size() > 0) {
            return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No room available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchRoomById(@PathVariable("id") String id){
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No room available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoom( @RequestBody Room room){
        roomService.addRoom(room);
        return new ResponseEntity<>("Room added successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRoom(Room room){
        roomService.updateRoom(room);
        return new ResponseEntity<>("Room updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") String id){
        try {
            roomService.deleteRoom(id);
            return new ResponseEntity<String>("Room with id: "+id+" is deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
