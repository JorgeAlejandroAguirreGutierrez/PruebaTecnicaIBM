package com.backend.ibm.BackEndIBM;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.ibm.BackEndIBM.models.Customer;
import com.backend.ibm.BackEndIBM.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerTest {
	
	  private CustomerService customerService = new CustomerService();
	  
	  @Test public void getTest() { List<Customer>customers=customerService.get();
	  assertEquals(customers.get(0).getName(),"Luis Jaramillo"); }
	  
	  @Test public void getIDTest() { Customer customer=customerService.getID(2L);
	  assertEquals(customer.getName(),"Jorge Rodriguez"); }
	  
	  @Test public void getAll() { assertEquals(5, customerService.get().size()); }
	 
}
