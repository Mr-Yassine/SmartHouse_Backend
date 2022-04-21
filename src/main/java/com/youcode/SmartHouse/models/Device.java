package com.youcode.SmartHouse.models;

import com.youcode.SmartHouse.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    private String deviceId;
    private String device;
    private Status status;

    @DBRef
    private Room room;
}
