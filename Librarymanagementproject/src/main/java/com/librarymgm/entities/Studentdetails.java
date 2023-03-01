package com.librarymgm.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Studentissueandreceive")
public class Studentdetails {

	@Id
	private long sid;
	private String sname;
	private String branch;
	private int rollnumber;
	private double fine;
	private double finepaid;
	
	@OneToMany
	public List <Book> book;



	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public double getFinepaid() {
		return finepaid;
	}

	public void setFinepaid(double finepaid) {
		this.finepaid = finepaid;
	}






	@Override
	public String toString() {
		return "Studentdetails [sid=" + sid + ", sname=" + sname + ", branch=" + branch + ", rollnumber=" + rollnumber
				+ ", fine=" + fine + ", finepaid=" + finepaid + ", book=" + book + "]";
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Studentdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
