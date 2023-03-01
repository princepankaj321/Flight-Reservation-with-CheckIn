package com.pankajcreation.flightreservation.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pankajcreation.flightreservation.controllers.Reservationcontroller;
import com.pankajcreation.flightreservation.dto.Reservationrequest;
import com.pankajcreation.flightreservation.entities.Flight;
import com.pankajcreation.flightreservation.entities.Passenger;
import com.pankajcreation.flightreservation.entities.Reservation;
import com.pankajcreation.flightreservation.repos.Flightrepository;
import com.pankajcreation.flightreservation.repos.Passengerrepository;
import com.pankajcreation.flightreservation.repos.Reservationrepository;
import com.pankajcreation.flightreservation.utilmail.Emailutilsendingconfig;
import com.pankajcreation.flightreservation.utilmail.Pdfgenerator;

@Service

public class Reservationserviceimpl implements Reservationservices {

	@Value("${com.pankajcreation.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR ;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Reservationserviceimpl.class);

	@Autowired
	private Flightrepository flightrepository;
	
	@Autowired
	private Passengerrepository passengerrepository;
	
	@Autowired
	private Reservationrepository reservationrepository;

	@Autowired
	private Pdfgenerator pdfgenerator;
	
	@Autowired
	private Emailutilsendingconfig emailutilsendingconfig;
	
	@Override
	@Transactional // save everything or save nothing. the concept about rolled back
	public Reservation bookflight(Reservationrequest request) {
		// TODO Auto-generated method stub
		//payment code here.
		logger.info("this is inside of this method ->  bookflight() ");
		
		
		long flightid = request.getFlightid();
		Optional<Flight> optionalFlight = this.flightrepository.findById(flightid);
		Flight flight = optionalFlight.orElse(null);
		
		logger.info("fetching flight info by flight id"+flightid);
		
		Passenger ps = new Passenger();
		ps.setFirstname(request.getPassengerFirstName());
		ps.setLastname(request.getPassengerLastName());
		ps.setPhone(request.getPassengerPhone());
		ps.setEmail(request.getPassengerEmail());
		logger.info("saving the passenger"+ps);
		
		Passenger save = this.passengerrepository.save(ps);
		
		Reservation rs = new Reservation();
		rs.setFlight(flight);
		rs.setPassenger(save);
		rs.setCheckedin(false);
		logger.info("saving the reservation"+rs);
		
		Reservation reservationsave = this.reservationrepository.save(rs);
		
		
		String filepath = +reservationsave.getId()+".pdf";
		
		logger.info("generating itinenary ");
		
		this.pdfgenerator.generateitnary(reservationsave,filepath);
		
		logger.info("emailing the itinenary ");
		
		emailutilsendingconfig.mailsenderflight(ps.getEmail(), filepath);
		
		return reservationsave;
	
	
	}

}
