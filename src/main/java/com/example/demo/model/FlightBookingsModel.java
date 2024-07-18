package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class FlightBookingsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightBookingId;
	private int flightId;
	private int userId;
	private String departureCity;
	private String arrivalCity;
	private String flightDate;
	private String flightTime;
	private double totalPrice;
	private int bookedSeats;
	private String airlineCompany;
	private String bookingStatus;
	private String paymentMethod;
	private String transactionId;
	private String bookingReference;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "flight_booking_id")
	private List<PassengerDetails> passengerInfo;
}
