package com.backend.ibm.BackEndIBM.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ibm.BackEndIBM.models.Card;
import com.backend.ibm.BackEndIBM.models.Customer;
import com.backend.ibm.BackEndIBM.services.CardService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/ibm/card")
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
		Map<String, Object> response = new HashMap<>();
		try {
			Card customer = microservice.getID(id);
			return new ResponseEntity<Card>(customer, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/{id}/historys", produces = "application/json")
	public ResponseEntity<?> getHistorys(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Card card= microservice.getHistorys(id);
			return new ResponseEntity<Card>(card, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> registrar(@RequestBody Card card) {
		Map<String, Object> response = new HashMap<>();
		try {
			Card ccard= microservice.create(card);
			return new ResponseEntity<Card>(ccard, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody Card card) {
		Map<String, Object> response = new HashMap<>();
		try {
			Card ucard= microservice.update(card);
			return new ResponseEntity<Card>(ucard, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Boolean bandera= microservice.delete(id);
			return new ResponseEntity<Boolean>(bandera, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
