package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ibm.BackEndIBM.dao.ICustomerDAO;
import com.backend.ibm.BackEndIBM.models.Customer;

@Service
public class CustomerService implements ICustomer {

	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public ArrayList<Customer> get() {
		return (ArrayList<Customer>) customerDAO.findAll();
	}
	
	@Override
	public Customer getID(Long id) {
		return customerDAO.findById(id).get();
	}

}
