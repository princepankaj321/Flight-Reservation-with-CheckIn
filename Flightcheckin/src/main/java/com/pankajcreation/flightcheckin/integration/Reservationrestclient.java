package com.pankajcreation.flightcheckin.integration;

import org.springframework.stereotype.Component;

import com.pankajcreation.flightcheckin.integration.dto.Reservation;
import com.pankajcreation.flightcheckin.integration.dto.Reservationupdaterequest;


public interface Reservationrestclient {

	public Reservation findreservation(long id);
	
	public Reservation updatereservation(Reservationupdaterequest request );



}
