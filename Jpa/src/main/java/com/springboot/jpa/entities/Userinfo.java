package com.springboot.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userinfo {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int uid;
	private String uname;
	private String ucity;
	private long unum;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public long getUnum() {
		return unum;
	}
	public void setUnum(long unum) {
		this.unum = unum;
	}
	public Userinfo( String uname, String ucity, long unum) {
		super();
		
		this.uname = uname;
		this.ucity = ucity;
		this.unum = unum;
	}
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", ucity=" + ucity + ", unum=" + unum + "]";
	}
	
	
	
}
