package com.backend.ibm.BackEndIBM.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.ibm.BackEndIBM.models.Card;
import com.backend.ibm.BackEndIBM.services.CardService;

public class CardController {

	@Autowired
	private CardService microservice;

	@GetMapping(produces = "application/json")
	public ResponseEntity<ArrayList<Card>> get() {
		ArrayList<Card> cards = new ArrayList<>();
		cards = microservice.get();
		return new ResponseEntity<ArrayList<Card>>(cards, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> getID(@PathVariable("id") Long id) {
		try {
			Card customer = microservice.getID(id);
			return new ResponseEntity<Card>(customer, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Customer> registrar(@RequestBody Customer customer) {
		try {
			Customer ccustomer = microservice.create(customer);
			return new ResponseEntity<Customer>(ccustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		try {
			Customer ucustomer = microservice.update(customer);
			return new ResponseEntity<Customer>(ucustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable("id") long id) {
		try {
			Boolean bandera= microservice.delete(id);
			return new ResponseEntity<Boolean>(bandera, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
