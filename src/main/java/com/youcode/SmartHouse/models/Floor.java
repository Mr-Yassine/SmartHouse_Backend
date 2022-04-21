package com.youcode.SmartHouse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
    @Id
    private String floorId;
    private String floor;

    @DBRef
    private List<Room> rooms;
    @DBRef
    private House house;
}
