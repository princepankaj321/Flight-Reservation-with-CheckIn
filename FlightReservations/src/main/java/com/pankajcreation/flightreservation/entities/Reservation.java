package com.pankajcreation.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean checkedin;
	private int numofbags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isCheckedin() {
		return checkedin;
	}
	public void setCheckedin(boolean checkedin) {
		this.checkedin = checkedin;
	}
	public int getNumofbags() {
		return numofbags;
	}
	public void setNumofbags(int numofbags) {
		this.numofbags = numofbags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkedin=" + checkedin + ", numofbags=" + numofbags + ", passenger="
				+ passenger + ", flight=" + flight + "]";
	}
	
	
	
	
	
}
