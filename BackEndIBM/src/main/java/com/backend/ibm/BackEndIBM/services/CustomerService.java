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

	@Override
	public Customer create(Customer customer) {
		Customer ccustomer=customerDAO.save(customer);
		return ccustomer;
	}

	@Override
	public Customer update(Customer customer) {
		Customer ucustomer=customerDAO.findById(customer.getId()).get();
		ucustomer.setName(customer.getName());
		ucustomer.setPhone(customer.getPhone());
		ucustomer.setAddress(customer.getAddress());
		ucustomer.setCity(customer.getCity());
		ucustomer=customerDAO.save(ucustomer);
		return ucustomer;
	}

	@Override
	public Boolean delete(Long id) {
		try { 
			customerDAO.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public Customer getCards(Long id) {
		return customerDAO.findById(id).get();
	}

}
