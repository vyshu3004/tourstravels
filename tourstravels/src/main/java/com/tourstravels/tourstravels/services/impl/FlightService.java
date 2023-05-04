package com.tourstravels.tourstravels.services.impl;

import com.tourstravels.tourstravels.models.Flight;
import com.tourstravels.tourstravels.repos.FlightRepository;
import com.tourstravels.tourstravels.services.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public List<Flight> getAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight getById(Long id) {
		return   flightRepository.findById(id).get();
	}

	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public void deleteById(Long id) {
		flightRepository.deleteById(id);

	}

	@Override
	public Flight findByfName(String fName) {
		return flightRepository.findByfName(fName);
	}



}
