package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FlightBookingsModel;
import com.example.demo.service.FlightBookingsService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class FlightBookingsController {

	private final FlightBookingsService flightBookingsService;

	@Autowired
	public FlightBookingsController(FlightBookingsService flightBookingsService) {
		this.flightBookingsService = flightBookingsService;
	}

	@PostMapping("/create")
	public ResponseEntity<FlightBookingsModel> createFlightBooking(@RequestBody FlightBookingsModel flightBooking) {
		FlightBookingsModel createdFlightBooking = flightBookingsService.saveFlightBooking(flightBooking);
		return new ResponseEntity<>(createdFlightBooking, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FlightBookingsModel>> getAllFlightBookings() {
		List<FlightBookingsModel> flightBookings = flightBookingsService.getAllFlightBookings();
		return new ResponseEntity<>(flightBookings, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<FlightBookingsModel> getFlightBookingById(@PathVariable int id) {
		Optional<FlightBookingsModel> flightBooking = flightBookingsService.getFlightBookingById(id);
		return flightBooking.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/userBooking/{userId}")
	public ResponseEntity<List<FlightBookingsModel>> getFlightsByUserId(@PathVariable int userId) {
		List<FlightBookingsModel> flightBookings = flightBookingsService.getFlightsByUserId(userId);
		return new ResponseEntity<>(flightBookings, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Void> updateFlightBooking(@RequestBody FlightBookingsModel flightBooking) {
		flightBookingsService.updateFlightBooking(flightBooking);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFlightBooking(@PathVariable int id) {
		flightBookingsService.deleteFlightBooking(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
