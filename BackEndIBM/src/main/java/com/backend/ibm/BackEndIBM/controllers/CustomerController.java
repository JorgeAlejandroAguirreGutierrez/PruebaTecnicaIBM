package com.backend.ibm.BackEndIBM.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.backend.ibm.BackEndIBM.models.Customer;
import com.backend.ibm.BackEndIBM.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService microservice;

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> get() {
		try {
		ArrayList<Customer> customers;
		customers = microservice.get();
		return new ResponseEntity<ArrayList<Customer>>(customers, HttpStatus.OK);
		}catch (DataAccessException e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> getID(@PathVariable("id") Long id) {
		try {
			Customer customer = microservice.getID(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> registrar(@RequestBody Customer customer) {
		try {
			Customer ccustomer = microservice.create(customer);
			return new ResponseEntity<Customer>(ccustomer, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		try {
			Customer ucustomer = microservice.update(customer);
			return new ResponseEntity<Customer>(ucustomer, HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		try {
			Boolean bandera= microservice.delete(id);
			return new ResponseEntity<Boolean>(bandera, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
