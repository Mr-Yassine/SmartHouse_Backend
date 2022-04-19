package com.youcode.SmartHouse.repositories;

import com.youcode.SmartHouse.models.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<Device, Long> {
}
