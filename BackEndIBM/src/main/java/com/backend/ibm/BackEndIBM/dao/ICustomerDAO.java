package com.backend.ibm.BackEndIBM.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.ibm.BackEndIBM.models.Customer;

public interface ICustomerDAO extends CrudRepository<Customer, Long> {

}
