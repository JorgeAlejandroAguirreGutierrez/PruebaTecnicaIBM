package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import com.backend.ibm.BackEndIBM.models.Customer;

public interface ICustomer {
	public ArrayList<Customer> get();
	public Customer getID(Long id);
}
