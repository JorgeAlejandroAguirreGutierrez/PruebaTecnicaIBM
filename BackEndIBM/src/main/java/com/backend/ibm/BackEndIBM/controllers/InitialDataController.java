package com.backend.ibm.BackEndIBM.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ibm.BackEndIBM.models.Customer;
import com.backend.ibm.BackEndIBM.models.History;
import com.backend.ibm.BackEndIBM.models.Adviser;
import com.backend.ibm.BackEndIBM.models.Card;
import com.backend.ibm.BackEndIBM.services.AdviserService;
import com.backend.ibm.BackEndIBM.services.CardService;
import com.backend.ibm.BackEndIBM.services.CustomerService;
import com.backend.ibm.BackEndIBM.services.HistoryService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/ibm/data")
public class InitialDataController {

	@Autowired
	private AdviserService adviserService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CardService cardService;

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> initialDATA() {
		Map<String, Object> response = new HashMap<>();
		try {
			customerService.create(new Customer("Luis Jaramillo", "Carrera 1 #1-11", "Medellin", "313339889"));
			customerService.create(new Customer("Jorge Rodriguez", "Carrera 2 #2-12", "Medellin", "313339889"));
			customerService.create(new Customer("Pedro Carmona", "Carrera 3 #3-13", "Medellin", "311345555"));
			customerService.create(new Customer("Luisa Grajales", "Carrera 4 #4-14", "Medellin", "3134445554"));
			customerService.create(new Customer("Carolina Aguirre", "Carrera 5 #5-55", "Medellin", "313339899"));
			cardService.create(new Card("1111-1111-1111-1111", "111", "Credito", 1));
			cardService.create(new Card("2222-2222-2222-2222", "222", "Credito", 2));
			cardService.create(new Card("3333-3333-3333-3333", "333", "Credito", 3));
			cardService.create(new Card("4444-4444-4444-4444", "444", "Credito", 4));
			cardService.create(new Card("4444-4444-4444-4444", "555", "Credito", 5));

			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"), 200000, "Pago Factura 1", 1));
			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-02"), 300000, "Pago Factura 2", 1));
			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-03"), 400000, "Pago Factura 3", 2));
			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-04"), 500000, "Pago Factura 4", 2));
			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05"), 600000, "Pago Factura 5", 3));
			historyService.create(new History(new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-06"), 700000, "Pago Factura 6", 3));

			adviserService.create(new Adviser("Camilo Lopez", "Cajero"));
			adviserService.create(new Adviser("Lorena Ruiz", "Comercial"));
			adviserService.create(new Adviser("Valentia Valencia", "Cajero"));

			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (DataAccessException | ParseException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
