package com.pankajcreation.flightreservation.entities;



import java.sql.Timestamp;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String flightnum;
	private String operatingairline;
	private String departurecity;
	private String arrivalcity;
	private Date dateofdeparture;
	private Timestamp estimateddeparturetime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
