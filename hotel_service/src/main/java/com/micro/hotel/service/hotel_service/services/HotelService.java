package com.micro.hotel.service.hotel_service.services;


import com.micro.hotel.service.hotel_service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //add hotel
    Hotel savehotel (Hotel hotel);

    //get single hotel
    Hotel gethotel(String uid);

    //get list of  hotels
    List<Hotel> getAllUsers();
}
