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

    private final HouseRepository houseRepository;
    private final UserService userService;

    public List<House> getAllHouses(){
        return this.houseRepository.findAll();
    }

    public House getHouseById(String id) {
        return this.houseRepository.findById(id).orElse(null);
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

    public void deleteHouse(String id) {
        this.houseRepository.deleteById(id);
    }

}
