package com.backend.ibm.BackEndIBM.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(nullable = false, length = 100)
	private String description;
	
	@Column(nullable = false, length = 12, precision = 2)
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "card_id", nullable = false)
	@JsonIgnore
	private Card card;
	
	public History(Date date, double amount, String description, long card_id) {
		
		this.amount=amount;
		this.date=date;
		this.description=description;
		this.card=new Card(card_id);
	}
	
	public History() {
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}
