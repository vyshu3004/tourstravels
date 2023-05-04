package com.tourstravels.tourstravels.repos;
import com.tourstravels.tourstravels.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	Flight findByfName(String fName);
	}



