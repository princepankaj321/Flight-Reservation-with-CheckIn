package com.librarymgm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bookdetails")
public class Book extends Logicbuilding {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long bid;
	@Column(name = "Bookname")
	private String bname;
	@Column(name = "Bookdescription")
	private String bdes;
	@Column(name = "Bookprize")
	private double bprize;
	@Column(name = "issueornot")
	private boolean  issueornot;
	
	
	
	
	@ManyToOne
	private Studentdetails studentdetails;


	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
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

	public String getBdes() {
		return bdes;
	}

	public void setBdes(String bdes) {
		this.bdes = bdes;
	}

	public double getBprize() {
		return bprize;
	}

	public void setBprize(double bprize) {
		this.bprize = bprize;
	}

	public boolean isIssueornot() {
		return issueornot;
	}

	public void setIssueornot(boolean issueornot) {
		this.issueornot = issueornot;
	}

	public Studentdetails getStudentdetails() {
		return studentdetails;
	}

	public void setStudentdetails(Studentdetails studentdetails) {
		this.studentdetails = studentdetails;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bdes=" + bdes + ", bprize=" + bprize + ", issueornot="
				+ issueornot + ", studentdetails=" + studentdetails + "]";
	}



	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
