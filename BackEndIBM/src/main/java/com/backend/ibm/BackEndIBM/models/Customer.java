package com.backend.ibm.BackEndIBM.models;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 100)
	private String address;
	@Column(nullable = false, length = 30)
	private String city;
	@Column(nullable = false, length = 20)
	private String phone;
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String nombre) {
		this.name = nombre;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
