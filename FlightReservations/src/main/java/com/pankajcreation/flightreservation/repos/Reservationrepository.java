package com.pankajcreation.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankajcreation.flightreservation.entities.Passenger;
import com.pankajcreation.flightreservation.entities.Reservation;




public interface Reservationrepository extends JpaRepository<Reservation, Long> {

	Reservation findById(long id);
	
}
