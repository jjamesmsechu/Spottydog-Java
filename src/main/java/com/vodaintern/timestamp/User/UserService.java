package com.vodaintern.timestamp.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Users> getUser(){
        return userRepository.findAll();
    }

    public void createUser(Users user) {
        userRepository.save(user);
    }

    public void deleteUser(Long userid) {
        boolean exists = userRepository.existsById(userid);
        if (!exists){
            throw new IllegalStateException("No User With Given ID Found");
        }
        userRepository.deleteById(userid);
    }
}