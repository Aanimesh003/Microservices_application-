package com.micro.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Rating {

    private String ratingId;
    private  String userId;
    private  String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
    List<Rating> ratings;
    public Rating()
    {
        ratings = new ArrayList<>();
    }
}
