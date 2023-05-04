package com.tourstravels.tourstravels.services.impl;

import com.tourstravels.tourstravels.models.Place;
import com.tourstravels.tourstravels.repos.PlaceRepository;
import com.tourstravels.tourstravels.services.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService  implements IPlaceService {

	@Autowired PlaceRepository placeRepository;
	public List<Place> listAll(){
		return placeRepository.findAll();
	}

	public void deleteById(Long id) {
		placeRepository.deleteById(id);
	}

	@Override
	public Place getById(Long id) {
		return placeRepository.findById(id).get();
	}

	@Override
	public Place addPlaces(Place p) {
		return placeRepository.save(p);
	}

	@Override
	public Place updatePlaces(Place p) {
		return placeRepository.save(p);
	}

	@Override
	public Place getByPlaceName(String pname) {
		return placeRepository.findBypname(pname);
	}

}
