package com.micro.rating.service.rating_service.respositories;

import com.micro.rating.service.rating_service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface rating_repository extends MongoRepository<Rating,String> {

    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
