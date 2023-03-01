package com.pankajcreation.flightreservation.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pankajcreation.flightreservation.entities.Flight;
import com.pankajcreation.flightreservation.repos.Flightrepository;

@Controller
public class Flightcontroller {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Flightcontroller.class);
	
	@Autowired
	private Flightrepository flightrepository;
	
	@RequestMapping(value ="/findflight")
	public String findflight(@RequestParam("from") String from,@RequestParam("to") String to, 
		@RequestParam("departuredate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departuredate, ModelMap map)
	{
		
		logger.info("this is inside of this method ->  findflight()"+from+"from "+to+"to ","departure data "+departuredate);
		
		List<Flight> search =this.flightrepository.findflightby(from,to,departuredate);
		for (Flight flight : search) {
		    System.out.println(flight);
		}
		
		map.addAttribute("flight", search);
		
		logger.info("flight found are "+search);
		
		return "displayflight";
	}
	
	
	
	// all code about admin
	
	
	@GetMapping("admin/flights")
	public String getAllFlights(Model model) {
		List<Flight> flights = flightrepository.findAll();
		model.addAttribute("flights", flights);
		return "flightList";
	}
	
	
	
	
	@GetMapping("admin/flights/add")
	public String showAddFlightForm(Model model) {
		model.addAttribute("flight", new Flight());
		return "addFlight";
	}

	@PostMapping("admin/flights")
	public String addFlight(@ModelAttribute("flight") Flight flight) {
	    flightrepository.save(flight);
	    return "redirect:/admin/flights";
	}


	@GetMapping("admin/flights/{id}/edit")
	public String showEditFlightForm(@PathVariable("id") long id, Model model) {
		Optional<Flight> flight = flightrepository.findById(id);
		if (flight.isPresent()) {
			model.addAttribute("flight", flight.get());
			return "editFlight";
		} else {
			return "404";
		}
	}

	@Transactional
	@PostMapping("admin/flights/{id}")
	public String updateFlight(@PathVariable("id") long id, @ModelAttribute("flight") Flight flight ) {
		Optional<Flight> existingFlight = flightrepository.findById(id);
		if (existingFlight.isPresent()) {
			existingFlight.get().setFlightnum(flight.getFlightnum());
			existingFlight.get().setOperatingairline(flight.getOperatingairline());
			existingFlight.get().setDeparturecity(flight.getDeparturecity());
			existingFlight.get().setArrivalcity(flight.getArrivalcity());
			existingFlight.get().setDateofdeparture(flight.getDateofdeparture());
			existingFlight.get().setEstimateddeparturetime(flight.getEstimateddeparturetime());
			flightrepository.save(existingFlight.get());
			return "redirect:/admin/flights";
		} else {
			return "404";
		}
	}

	@GetMapping("admin/flights/{id}/delete")
	public String deleteFlight(@PathVariable("id") long id) {
	  logger.info("Deleting flight with ID {}", id);
	  flightrepository.deleteById(id);
	  logger.info("Flight with ID {} deleted successfully", id);
	  return "redirect:/admin/flights";
	}


	
	
	
	
	
}
