package com.micro.rating.service.rating_service.services;

import com.micro.rating.service.rating_service.entities.Rating;

import java.util.List;

public interface rating_service {

    //create rating
    Rating createRating(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    //get all ratings by userId
    List<Rating> getRatingByUserId(String userId);

    //get all ratings by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
