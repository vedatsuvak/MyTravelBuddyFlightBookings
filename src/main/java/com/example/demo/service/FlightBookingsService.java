package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FlightBookingsModel;
import com.example.demo.repository.FlightBookingsRepository;

@Service
public class FlightBookingsService {

	private final FlightBookingsRepository flightBookingsRepository;

	@Autowired
	public FlightBookingsService(FlightBookingsRepository flightBookingsRepository) {
		this.flightBookingsRepository = flightBookingsRepository;
	}

	public FlightBookingsModel saveFlightBooking(FlightBookingsModel flightBooking) {
		return flightBookingsRepository.save(flightBooking);
	}

	public List<FlightBookingsModel> getAllFlightBookings() {
		return flightBookingsRepository.findAll();
	}

	public Optional<FlightBookingsModel> getFlightBookingById(int id) {
		return flightBookingsRepository.findById(id);
	}

	public List<FlightBookingsModel> getFlightsByUserId(int userId) {
		return flightBookingsRepository.findByUserId(userId);
	}

	public void updateFlightBooking(FlightBookingsModel flightBooking) {
		flightBookingsRepository.save(flightBooking);
	}

	public void deleteFlightBooking(int id) {
		flightBookingsRepository.deleteById(id);
	}
}
