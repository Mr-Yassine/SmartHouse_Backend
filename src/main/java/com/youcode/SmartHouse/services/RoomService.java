package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.models.House;
import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.repositories.HouseRepository;
import com.youcode.SmartHouse.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final FloorService floorService;

    public List<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

    public Room getRoomById(String id) {
        return this.roomRepository.findById(id).orElse(null);
    }

    public Room addRoom(Room room) {
        Floor getFLoorData = floorService.getFloorById(room.getFloor().getFloorId());
        if(getFLoorData != null){
            room.setFloor(getFLoorData);
            this.roomRepository.save(room);
        }
        return room;
    }

    public void updateRoom(Room room) {
        this.roomRepository.save(room);
    }

    public void deleteRoom(String id) {
        this.roomRepository.deleteById(id);
    }


}
