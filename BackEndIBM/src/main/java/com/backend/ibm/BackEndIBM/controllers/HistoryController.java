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

import com.backend.ibm.BackEndIBM.models.History;
import com.backend.ibm.BackEndIBM.services.HistoryService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/ibm/history")
public class HistoryController {
	
	@Autowired
	private HistoryService microservice;

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> get() {
		Map<String, Object> response = new HashMap<>();
		try {
			ArrayList<History> historys;
			historys = microservice.get();
			return new ResponseEntity<ArrayList<History>>(historys, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> getID(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			History history = microservice.getID(id);
			return new ResponseEntity<History>(history, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> registrar(@RequestBody History history) {
		Map<String, Object> response = new HashMap<>();
		try {
			History chistory = microservice.create(history);
			return new ResponseEntity<History>(chistory, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody History History) {
		Map<String, Object> response = new HashMap<>();
		try {
			History uhistory = microservice.update(History);
			return new ResponseEntity<History>(uhistory, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Boolean bandera = microservice.delete(id);
			return new ResponseEntity<Boolean>(bandera, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
