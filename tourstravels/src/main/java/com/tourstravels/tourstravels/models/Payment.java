package com.tourstravels.tourstravels.models;

import jakarta.persistence.*;
@Entity

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="bookingid")
	private Booking booking;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	private Long amount;
	private String mode;
	private String date;

}
