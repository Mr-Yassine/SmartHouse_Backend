package com.youcode.SmartHouse.repositories;

import com.youcode.SmartHouse.models.House;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface HouseRepository extends MongoRepository<House, String> {
}
