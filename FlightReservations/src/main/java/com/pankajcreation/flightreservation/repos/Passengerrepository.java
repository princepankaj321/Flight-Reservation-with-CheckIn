package com.pankajcreation.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pankajcreation.flightreservation.entities.Passenger;


public interface Passengerrepository extends JpaRepository<Passenger, Long> {

}
