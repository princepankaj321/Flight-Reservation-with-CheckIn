package com.pankajcreation.flightcheckin.integration.dto;



import java.sql.Timestamp;

import java.time.LocalDate;
import java.util.Date;

public class Flight {

	private long id;

	private String flightnum;
	private String operatingairline;
	private String departurecity;
	private String arrivalcity;
	private Date dateofdeparture;
	private Timestamp estimateddeparturetime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlightnum() {
		return flightnum;
	}
	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}
	public String getOperatingairline() {
		return operatingairline;
	}
	public void setOperatingairline(String operatingairline) {
		this.operatingairline = operatingairline;
	}
	public String getDeparturecity() {
		return departurecity;
	}
	public void setDeparturecity(String departurecity) {
		this.departurecity = departurecity;
	}
	public String getArrivalcity() {
		return arrivalcity;
	}
	public void setArrivalcity(String arrivalcity) {
		this.arrivalcity = arrivalcity;
	}
	public Date getDateofdeparture() {
		return dateofdeparture;
	}
	public void setDateofdeparture(Date dateofdeparture) {
		this.dateofdeparture = dateofdeparture;
	}
	public Timestamp getEstimateddeparturetime() {
		return estimateddeparturetime;
	}
	public void setEstimateddeparturetime(Timestamp estimateddeparturetime) {
		this.estimateddeparturetime = estimateddeparturetime;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightnum=" + flightnum + ", operatingairline=" + operatingairline
				+ ", departurecity=" + departurecity + ", arrivalcity=" + arrivalcity + ", dateofdeparture="
				+ dateofdeparture + ", estimateddeparturetime=" + estimateddeparturetime + "]";
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
