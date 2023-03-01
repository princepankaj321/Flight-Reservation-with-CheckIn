package com.pankajcreation.flightreservation.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pankajcreation.flightreservation.dto.Reservationrequest;
import com.pankajcreation.flightreservation.entities.Flight;
import com.pankajcreation.flightreservation.entities.Reservation;
import com.pankajcreation.flightreservation.repos.Flightrepository;
import com.pankajcreation.flightreservation.repos.Reservationrepository;
import com.pankajcreation.flightreservation.services.Reservationservices;

@Controller
public class Reservationcontroller {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Reservationcontroller.class);

	@Autowired
	private Flightrepository flightrepository;
	
	
	@Autowired
	Reservationservices  reservationservices;
	
	@RequestMapping (value ="/showcompletereservation")
	public String showreservation(@RequestParam("id") long id, ModelMap map)
	{
		logger.info("this is inside of this method ->  showreservation() and it is invoked with flight"+id+"id "+map+"map");
		
		Optional<Flight> findById = this.flightrepository.findById(id); 
		map.addAttribute("reservation", findById);
		logger.info("flight is"+findById);
		return "completereservation";
	}
	
	@RequestMapping(value ="/completeReservation", method = RequestMethod.POST)
	public String completereservation(Reservationrequest request, ModelMap map)
	{
		logger.info("this is inside of this method ->  completereservation() "+request+"request and"+map+"map");
		
		Reservation reservation = this.reservationservices.bookflight(request);
		
		map.addAttribute("msg2", "Reservation created successfully and id is "+ reservation.getId());
		
		return "reservationconfirmation";
		
	}
	
}
