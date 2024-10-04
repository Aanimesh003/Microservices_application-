package com.micro.hotel.service.hotel_service.cotrollers;

import com.micro.hotel.service.hotel_service.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.micro.hotel.service.hotel_service.services.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelservice;

    //add hotels
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.savehotel(hotel));
    }
    //get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(hotelservice.getAllUsers());
    }

    //get single hotel
    @GetMapping("/{UID}")
    public ResponseEntity<Hotel> getHotelByUid(@PathVariable String UID)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelservice.gethotel(UID));
    }
}
