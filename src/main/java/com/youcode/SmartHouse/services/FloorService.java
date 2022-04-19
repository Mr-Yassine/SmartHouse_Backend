package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.Floor;
import com.youcode.SmartHouse.repositories.FloorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorService {

    private  final FloorRepository floorRepository;

    public List<Floor> getAllFloors(){
        return this.floorRepository.findAll();
    }

    public Floor getFloorById(Long id) {
        return null;
    }

    public void addFloor(Floor floor) {
    }

    public void updateFloor(Floor floor) {
    }

    public void deleteFloor(Long id) {
    }
}
