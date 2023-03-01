package com.pankajcreation.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankajcreation.flightreservation.dto.Reservationupdaterequest;
import com.pankajcreation.flightreservation.entities.Reservation;
import com.pankajcreation.flightreservation.repos.Reservationrepository;

@RestController
public class Reservationrestcontroller {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Reservationrestcontroller.class);

	@Autowired
	private Reservationrepository reservationrepository;
	
	@RequestMapping( "/reservations/{id}")
	public Reservation findreservation(@PathVariable ("id")long id)
	{
		logger.info("this is inside of this method ->  findreservation() and it is for"+id+"id");
		
		Reservation id2 = this.reservationrepository.findById(id);
		
		return id2;
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updatereservation(@RequestBody Reservationupdaterequest request )
	{
		logger.info("this is inside of this method ->  updatereservation() and it is for"+request+"request");

		Reservation updatereserv = this.reservationrepository.findById(request.getId());
		updatereserv.setNumofbags(request.getNumofbags());
		updatereserv.setCheckedin(request.getCheckedin());
		Reservation updatedreservation = reservationrepository.save(updatereserv);
		
		logger.info("this is inside of this method ->  updatereservation() and it saving the reservations");

		return updatedreservation;
	}
	
}
