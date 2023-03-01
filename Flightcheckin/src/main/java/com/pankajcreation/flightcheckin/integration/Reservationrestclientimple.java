package com.pankajcreation.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pankajcreation.flightcheckin.integration.dto.Reservation;
import com.pankajcreation.flightcheckin.integration.dto.Reservationupdaterequest;

@Component
public class Reservationrestclientimple implements Reservationrestclient {

	@Override
	public Reservation findreservation(long id) {
		
		RestTemplate template = new RestTemplate();
		
		
		Reservation reservation = 
				template.getForObject("http://localhost:8080/reservations/"+id, Reservation.class);
		
		System.out.println(reservation +"this is find reservation object Rest template");
		
		return reservation;
	}

	@Override
	public Reservation updatereservation(Reservationupdaterequest request) {
		
		
		RestTemplate template = new RestTemplate();
		
		Reservation reservation2 = template.postForObject("http://localhost:8080/reservations/", request, Reservation.class);
		System.out.println(reservation2 +"this is updation object");
		
		return reservation2;
	}

}
