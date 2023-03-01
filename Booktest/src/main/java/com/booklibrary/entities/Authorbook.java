package com.booklibrary.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Authorbook {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int aid;
	private String Authorname;
	
	@OneToOne(mappedBy = "authorbook")
	@JsonBackReference
	private Bookdetails bookdetails;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAuthorname() {
		return Authorname;
	}

	public void setAuthorname(String authorname) {
		Authorname = authorname;
	}

	public Bookdetails getBookdetails() {
		return bookdetails;
	}

	public void setBookdetails(Bookdetails bookdetails) {
		this.bookdetails = bookdetails;
	}

	@Override
	public String toString() {
		return "Authorbook [aid=" + aid + ", Authorname=" + Authorname + ", bookdetails=" + bookdetails + "]";
	}

	public Authorbook(int aid, String authorname, Bookdetails bookdetails) {
		super();
		this.aid = aid;
		Authorname = authorname;
		this.bookdetails = bookdetails;
	}

	public Authorbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
