package com.micro.rating.service.rating_service.controllers;


import com.micro.rating.service.rating_service.entities.Rating;
import com.micro.rating.service.rating_service.services.rating_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class Rating_controller {

    @Autowired
    private rating_service ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody  Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getUserRatingById(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getHotelRatingById(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }
}
