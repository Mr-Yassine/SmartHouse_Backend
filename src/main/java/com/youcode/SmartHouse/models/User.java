package com.youcode.SmartHouse.models;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    private String userId;
    private String name;
    private String phone;
    @Indexed(unique = true)
    private String email;
    private String password;
    private LocalDateTime createdAt;

    @DBRef
    private List<House> houses;
}
