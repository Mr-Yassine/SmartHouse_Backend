package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.House;
import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.repositories.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class HouseService {

    @Autowired
    private final HouseRepository houseRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final FloorService floorService;

    public List<House> getAllHouses(){
        return this.houseRepository.findAll();
    }

    public Optional<House> getHouseById(Long id) {
        return this.houseRepository.findById(id);
    }

    public House addHouse(House house) {
        User getUserData = userService.findById(house.getUser().getUserId());
        if(getUserData != null){
            house.setUser(getUserData);
            this.houseRepository.save(house);
        }
        return house;
    }

    public void updateHouse(House house) {
        this.houseRepository.save(house);
    }

    public void deleteHouse(House house) {
        this.houseRepository.delete(house);
    }
}
