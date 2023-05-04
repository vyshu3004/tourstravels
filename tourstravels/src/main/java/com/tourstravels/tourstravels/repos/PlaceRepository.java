package com.tourstravels.tourstravels.repos;

import com.tourstravels.tourstravels.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findBypname(String pname);
	
}
