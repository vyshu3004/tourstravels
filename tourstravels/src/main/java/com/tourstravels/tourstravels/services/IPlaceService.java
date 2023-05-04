package com.tourstravels.tourstravels.services;

import com.tourstravels.tourstravels.models.Place;

import java.util.List;

public interface IPlaceService {

    List<Place> listAll();
    void deleteById(Long id);

    Place getById(Long id);

    Place addPlaces(Place p);

    Place updatePlaces(Place p);

    Place getByPlaceName(String pname);
}
