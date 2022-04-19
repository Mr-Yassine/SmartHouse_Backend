package com.youcode.SmartHouse.repositories;

import com.youcode.SmartHouse.models.Room;
import com.youcode.SmartHouse.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends MongoRepository<Room, Long> {
}
