package com.youcode.SmartHouse.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class House {
    @Id
    private String houseId;
    private String house;

    @DBRef
    private List<Floor> floors;

    @DBRef
    private User user;

}
