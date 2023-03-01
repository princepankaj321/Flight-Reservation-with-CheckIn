package com.pankajcreation.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pankajcreation.flightreservation.entities.Flight;


public interface Flightrepository extends JpaRepository<Flight, Long> {

	
	@Query("from Flight where departurecity=:departurecity and arrivalcity=:arrivalcity and dateofdeparture=:dateofdeparture")
	List<Flight> findflightby(@Param("departurecity") String from, @Param("arrivalcity") String to, @Param("dateofdeparture") Date departuredate);
	
	/*
	 * @Query(value =
	 * "select * from flight where departurecity=:departurecity and arrivalcity=:arrivalcity and dateofdeparture=:dateofdeparture"
	 * , nativeQuery = true ) List<Flight> findflightby(@Param("departurecity")
	 * String from, @Param("arrivalcity") String to, @Param("dateofdeparture") Date
	 * departuredate);
	 */
}
