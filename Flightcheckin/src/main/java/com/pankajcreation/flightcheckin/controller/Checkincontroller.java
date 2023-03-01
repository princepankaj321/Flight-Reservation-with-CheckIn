package com.pankajcreation.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pankajcreation.flightcheckin.integration.Reservationrestclient;
import com.pankajcreation.flightcheckin.integration.dto.Reservation;
import com.pankajcreation.flightcheckin.integration.dto.Reservationupdaterequest;

@Controller
public class Checkincontroller {

	@Autowired
	Reservationrestclient reservationrestclient;
	
	@RequestMapping("/showstartcheckin")
	public String showstartcheckin()
	{
		
		return "startcheckin";
		
	}
	
	@RequestMapping("/startcheckin")
	public String startcheckin(@RequestParam ("id") long id, ModelMap map)
	{
		Reservation reservation = this.reservationrestclient.findreservation(id);
		map.addAttribute("viewreservation", reservation);
	
		System.out.println(reservation+"data is coming from this object");
		
		return "diplayreservationdetails";
		
		
				
	}
	
	@RequestMapping("/completecheckin")
	public String completecheckin(@RequestParam("id") long id, @RequestParam ("numofbags") int numofbags)
	{
		Reservationupdaterequest update = new Reservationupdaterequest();
		update.setId(id);
		update.setCheckedin(true);
		update.setNumofbags(numofbags);
		Reservation reservation2 = reservationrestclient.updatereservation(update);
		
		return "checkinconfirmation";
	}
	
}
