package com.youcode.SmartHouse.services;

import com.youcode.SmartHouse.models.User;
import com.youcode.SmartHouse.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User findById(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public void save(User user){
        this.userRepository.save(user);
    }

    public void update(User user) {
        this.userRepository.save(user);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }
}
