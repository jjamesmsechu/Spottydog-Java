package com.vodaintern.timestamp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<Users> getEntry(){
        return userService.getUser();
    };
    @PostMapping
    public void createEntry(@RequestBody Users user){
        userService.createUser(user);
    }
}
