package com.tourstravels.tourstravels.services.impl;

import com.tourstravels.tourstravels.models.Booking;
import com.tourstravels.tourstravels.models.Payment;
import com.tourstravels.tourstravels.repos.BookingRepository;
import com.tourstravels.tourstravels.repos.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {
	
	@Autowired BookingRepository repo;
	@Autowired
	UserService uservice;
	@Autowired PaymentRepository prepo;
	
	public Booking saveBooking(Booking b) {
		b.setStatus("Booked");
		return repo.save(b);	
	}
	
	public List<Booking> getAllBookings(){ 
		return repo.findAll();
	}
	


	public Booking findById(Long id) {
		return repo.getById(id);
	}
	
	public void savePayment(Payment pmt) {
		prepo.save(pmt);
	}
}
