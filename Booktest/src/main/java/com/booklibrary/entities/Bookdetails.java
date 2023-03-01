package com.booklibrary.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bookdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BookId")
	private int bid;
	@Column(name = "Bookname")
	private String bname;
	@Column(name = "addingDate")
	private Date date;
	@Column(name = "Description")
	private String des;
	@Column(name = "Quantity")
	private int qty;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Authorbook  authorbook;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Authorbook getAuthorbook() {
		return authorbook;
	}

	public void setAuthorbook(Authorbook authorbook) {
		this.authorbook = authorbook;
	}

	@Override
	public String toString() {
		return "Bookdetails [bid=" + bid + ", bname=" + bname + ", date=" + date + ", des=" + des + ", qty=" + qty
				+ ", authorbook=" + authorbook + "]";
	}

	public Bookdetails(int bid, String bname, Date date, String des, int qty, Authorbook authorbook) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.date = date;
		this.des = des;
		this.qty = qty;
		this.authorbook = authorbook;
	}

	public Bookdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
}
