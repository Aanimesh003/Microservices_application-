package com.micro.user.service.services;

import com.micro.user.service.entities.User;
import com.micro.user.service.payload.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users
    List<User> getAllUsers();

    // get single user by ID
    User getuser(String userId);

    //delete
    ResponseEntity<String> deleteUser(String  userId);

    // update
    ResponseEntity<String> updateUser(User user);
}
