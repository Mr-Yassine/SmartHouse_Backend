package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private  final RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return this.roomRepository.findById(id).orElse(null);
    }

    public void addRoom(Room room) {
    }

    public void updateRoom(Room room) {
    }

    public void deleteRoom(Room room) {
    }


}
