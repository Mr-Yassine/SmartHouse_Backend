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
    public ResponseEntity<?> fetchRoomById(@PathVariable("id") Long id){
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No room available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoom(Room room){
        roomService.addRoom(room);
        return new ResponseEntity<>("Room added successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRoom(Room room){
        roomService.updateRoom(room);
        return new ResponseEntity<>("Room updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(Room room){
        roomService.deleteRoom(room);
        return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
    }


}
