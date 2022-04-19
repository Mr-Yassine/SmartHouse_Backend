package com.youcode.SmartHouse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long floorId;
    private String floor;

    @DBRef
    private List<Room> rooms;
    @DBRef
    private House house;
}
