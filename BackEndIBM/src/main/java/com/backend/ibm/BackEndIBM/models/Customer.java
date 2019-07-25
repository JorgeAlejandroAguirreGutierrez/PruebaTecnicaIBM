package com.backend.ibm.BackEndIBM.models;

import java.io.Serializable;
import java.util.List;

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
	
	public Customer(String name, String address, String city, String phone) {
		this.name=name;
		this.address=address;
		this.city=city;
		this.phone=phone;
	}
	
	public Customer(long id) {
		this.id=id;
	}
	
	public Customer() {
		
	}
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity = Card.class, mappedBy = "customer")
	private List<Card> cards ;
	
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
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
