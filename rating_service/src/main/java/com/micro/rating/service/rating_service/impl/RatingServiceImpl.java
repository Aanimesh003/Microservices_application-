package com.micro.rating.service.rating_service.impl;

import com.micro.rating.service.rating_service.entities.Rating;
import com.micro.rating.service.rating_service.respositories.rating_repository;
import com.micro.rating.service.rating_service.services.rating_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RatingServiceImpl implements rating_service {

    @Autowired
    private rating_repository repository;

    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId( String userId) {
        return repository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.getRatingByHotelId(hotelId);
    }
}
