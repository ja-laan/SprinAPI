package com.example.demo;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") int userId)
        throws NotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("user not found"));
        return ResponseEntity.ok().body(user);
    }

//    @PostMapping("/users")
//    public User createUser(@Valid @RequestBody User user){
//        return userRepository.save(user);
//    }
}
