package com.micro.hotel.service.hotel_service.impl;

import com.micro.hotel.service.hotel_service.entities.Hotel;
import com.micro.hotel.service.hotel_service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micro.hotel.service.hotel_service.repositories.HotelRepository;
import com.micro.hotel.service.hotel_service.services.HotelService;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelrepo;

    @Override
    public Hotel savehotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelrepo.save(hotel);
    }

    @Override
    public Hotel gethotel(String uid) {
        return hotelrepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("hotel not found in the database"));
    }

    @Override
    public List<Hotel> getAllUsers() {
        return hotelrepo.findAll();
    }
}
