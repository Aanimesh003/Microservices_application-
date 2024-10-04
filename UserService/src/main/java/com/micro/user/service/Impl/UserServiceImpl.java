package com.micro.user.service.Impl;

import com.micro.user.service.entities.Hotel;
import com.micro.user.service.entities.Rating;
import com.micro.user.service.entities.User;
import com.micro.user.service.exceptions.ResourceNotFoundException;
import com.micro.user.service.external.services.HotelServices;
import com.micro.user.service.repositories.UserRepository;
import com.micro.user.service.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelservice;

    @Override
    public User saveUser(User user) {

        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepo.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getuser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id not found on server!: "+userId));
        ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
        List<Rating> ratingsOfUser = Arrays.stream(response.getBody()).toList();
        // another method
        //List<Rating> ratingOfUser = List.of(response.getBody());
        List<Rating> ratingList = ratingsOfUser.stream().map(rating -> {

            Hotel hotel = hotelservice.gethotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        //Hotel res = restTemplate.getForObject("http://localhost:8082/ratings/hotel/"+Rating.getHotelId(),Hotel.class);
        return user ;
    }

    @Override
    public ResponseEntity<String> deleteUser(String  userId) {

        if(userRepo.existsById(userId))
        {
            userRepo.deleteById(userId);
            return ResponseEntity.ok("user deleted");
        }
        else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> updateUser(User user) {

            if (!userRepo.existsById(user.getUserId())) {
                throw new ResourceNotFoundException("User not found: " + user.getUserId());
            }
            User existingUser = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("user not found "));
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            userRepo.save(existingUser);
            return ResponseEntity.ok("user Updated successfully");
    }
}