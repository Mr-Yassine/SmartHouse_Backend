package com.youcode.SmartHouse.repositories;

import com.youcode.SmartHouse.models.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends MongoRepository<Floor, String> {
}
