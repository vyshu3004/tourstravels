package com.tourstravels.tourstravels.repos;

import com.tourstravels.tourstravels.models.Booking;
import com.tourstravels.tourstravels.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByUser(User user);
}
