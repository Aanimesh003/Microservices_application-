package com.micro.user.service.controllers;

import com.micro.user.service.entities.User;
import com.micro.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user)
    {
        User user1 = userservice.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser( @PathVariable String  userId)
    {
       User user = userservice.getuser(userId);
       return ResponseEntity.ok(user);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
            List<User> users = userservice.getAllUsers();
            return  ResponseEntity.ok(users);
    }

    //delete user
    @PostMapping("/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable  String userId)
    {
        return  userservice.deleteUser(userId);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody  User user)
    {
        return userservice.updateUser(user);
    }

}
