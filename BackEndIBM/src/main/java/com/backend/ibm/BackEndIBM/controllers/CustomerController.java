package com.backend.ibm.BackEndIBM.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<ArrayList<Customer>> get() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers = microservice.get();
		return new ResponseEntity<ArrayList<Customer>>(customers, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Customer> getID(@PathVariable("id") Long id) {
		try {
			Customer customer = microservice.getID(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * @PostMapping(produces = "application/json", consumes = "application/json")
	 * public ResponseEntity<Customer> registrar(@RequestBody Customer customer) {
	 * try { Customer customer = microservice.create(customer); return new
	 * ResponseEntity<Customer>(customer, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<Customer>(new Customer(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * @PutMapping(produces = "application/json", consumes = "application/json")
	 * public ResponseEntity<Customer> update(@RequestBody Customer customer) { try
	 * { Customer customer = microservice.update(customer); return new
	 * ResponseEntity<Customer>(customer, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<Customer>(new Customer(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 * 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Customer>
	 * eliminar(@PathVariable("id") Integer id) { try { Customer customer =
	 * microservice.getID(id); customer = microservice.delete(customer); return new
	 * ResponseEntity<Customer>(customer, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<Customer>(new Customer(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
