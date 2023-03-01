package com.librarymgm.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	private int transactionID;
	private int transbookid;
	private String transbookname;
	private long transsid;
	private String transsname;
	private Date tranissuedate;
	private Date actualreturndate;
	private Date expectedreturndate;
	private int transactionfine;
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getTransbookid() {
		return transbookid;
	}
	public void setTransbookid(int transbookid) {
		this.transbookid = transbookid;
	}
	public String getTransbookname() {
		return transbookname;
	}
	public void setTransbookname(String transbookname) {
		this.transbookname = transbookname;
	}
	public long getTranssid() {
		return transsid;
	}
	public void setTranssid(long transsid) {
		this.transsid = transsid;
	}
	public String getTranssname() {
		return transsname;
	}
	public void setTranssname(String transsname) {
		this.transsname = transsname;
	}
	public Date getTranissuedate() {
		return tranissuedate;
	}
	public void setTranissuedate(Date tranissuedate) {
		this.tranissuedate = tranissuedate;
	}
	public Date getActualreturndate() {
		return actualreturndate;
	}
	public void setActualreturndate(Date actualreturndate) {
		this.actualreturndate = actualreturndate;
	}
	public Date getExpectedreturndate() {
		return expectedreturndate;
	}
	public void setExpectedreturndate(Date expectedreturndate) {
		this.expectedreturndate = expectedreturndate;
	}
	public int getTransactionfine() {
		return transactionfine;
	}
	public void setTransactionfine(int transactionfine) {
		this.transactionfine = transactionfine;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transbookid=" + transbookid + ", transbookname="
				+ transbookname + ", transsid=" + transsid + ", transsname=" + transsname + ", tranissuedate="
				+ tranissuedate + ", actualreturndate=" + actualreturndate + ", expectedreturndate="
				+ expectedreturndate + ", transactionfine=" + transactionfine + "]";
	}
	public Transaction(int transactionID, int transbookid, String transbookname, long transsid, String transsname,
			Date tranissuedate, Date actualreturndate, Date expectedreturndate, int transactionfine) {
		super();
		this.transactionID = transactionID;
		this.transbookid = transbookid;
		this.transbookname = transbookname;
		this.transsid = transsid;
		this.transsname = transsname;
		this.tranissuedate = tranissuedate;
		this.actualreturndate = actualreturndate;
		this.expectedreturndate = expectedreturndate;
		this.transactionfine = transactionfine;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
