package com.micro.user.service.external.services;

import com.micro.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {

    @GetMapping("hotels/{hotelId}")
    Hotel gethotel(@PathVariable String hotelId);

}
