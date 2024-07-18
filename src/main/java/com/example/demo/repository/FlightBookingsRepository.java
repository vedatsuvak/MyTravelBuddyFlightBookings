package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FlightBookingsModel;

@Repository
public interface FlightBookingsRepository extends JpaRepository<FlightBookingsModel, Integer> {

	List<FlightBookingsModel> findByUserId(int userId);

}
