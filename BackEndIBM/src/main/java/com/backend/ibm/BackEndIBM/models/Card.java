package com.backend.ibm.BackEndIBM.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;

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
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL, targetEntity=History.class )
	private List<History> historys;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Customer customer;
	
	
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
	
	
	
	
	
	
	
}
