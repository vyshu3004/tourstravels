package com.tourstravels.tourstravels.services;

import com.tourstravels.tourstravels.models.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getAllHotels();
    Hotel getById(Long id);
    void deleteById(Long id);

    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    Hotel getByHotelName(String hName);

}
