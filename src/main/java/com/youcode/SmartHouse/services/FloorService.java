package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.models.House;
import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.repositories.FloorRepository;
import com.youcode.SmartHouse.repositories.HouseRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;
    private final HouseService houseService;

    public List<Floor> getAllFloors(){
        return this.floorRepository.findAll();
    }

    public Floor getFloorById(String id) {
        return this.floorRepository.findById(id).orElse(null);
    }

    public Floor addFloor(Floor floor) {
        House getHouseData = houseService.getHouseById(floor.getHouse().getHouseId());
        if(getHouseData != null){
            floor.setHouse(getHouseData);
            this.floorRepository.save(floor);
        }
        return floor;
    }

    public void updateFloor(Floor floor) {
        this.floorRepository.save(floor);
    }

    public void deleteFloor(String id) {
        this.floorRepository.deleteById(id);
    }
}
