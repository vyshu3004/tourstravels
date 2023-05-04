package com.tourstravels.tourstravels.services.impl;

import com.tourstravels.tourstravels.models.Hotel;
import com.tourstravels.tourstravels.repos.HotelRepository;
import com.tourstravels.tourstravels.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();

	}

	@Override
	public Hotel getById(Long id) {
		return hotelRepository.findById(id).get();

	}

	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	public  Hotel getByHotelName(String hName){
		return hotelRepository.findByhName(hName);
	}

}
