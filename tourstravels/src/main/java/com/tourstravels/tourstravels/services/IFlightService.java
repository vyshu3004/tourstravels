package com.tourstravels.tourstravels.services;

import com.tourstravels.tourstravels.models.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> getAll();
    Flight getById(Long id);
    Flight saveFlight(Flight flight);
    void deleteById(Long id);
    Flight findByfName(String fName);


}
