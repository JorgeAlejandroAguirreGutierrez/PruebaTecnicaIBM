package com.backend.ibm.BackEndIBM.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 19)
	private String number;
	@Column(nullable = false, length = 4)
	private String ccv;
	@Column(nullable = false, length = 50)
	private String type;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity = History.class, mappedBy = "card")
	private List<History> historys ;
	
	public Card(String number, String ccv, String type, long customer_id) {
		this.number=number;
		this.ccv=ccv;
		this.type=type;
		this.customer=new Customer(customer_id);
	}
	
	public Card(long id) {
		this.id=id;
	}
	
	public Card() {
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<History> getHistorys() {
		return historys;
	}
	
	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}
	
}
