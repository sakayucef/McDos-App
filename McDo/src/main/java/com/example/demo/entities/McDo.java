package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class McDo implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	private double alt;
	private double longit;
	private String name;
	private String address;
	private String tel;
	
	
	
	
	public McDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public McDo(double alt, double longit, String name, String address, String tel) {
		super();
		this.alt = alt;
		this.longit = longit;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public double getLongit() {
		return longit;
	}
	public void setLongit(double longit) {
		this.longit = longit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
