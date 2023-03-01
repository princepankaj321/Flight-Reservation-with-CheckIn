package com.pankajcreation.flightcheckin.integration.dto;

public class Reservationupdaterequest {

	private long id;
	private Boolean checkedin;
	private int numofbags;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Boolean getCheckedin() {
		return checkedin;
	}
	public void setCheckedin(Boolean checkedin) {
		this.checkedin = checkedin;
	}
	public int getNumofbags() {
		return numofbags;
	}
	public void setNumofbags(int numofbags) {
		this.numofbags = numofbags;
	}
	public Reservationupdaterequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
