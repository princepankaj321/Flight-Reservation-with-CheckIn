package com.pankajcreation.flightreservation.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankajcreation.flightreservation.dto.Reservationrequest;
import com.pankajcreation.flightreservation.entities.Reservation;

public interface Reservationservices {

	public Reservation bookflight(Reservationrequest request);
	
}
