package com.backend.ibm.BackEndIBM;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.ibm.BackEndIBM.models.History;
import com.backend.ibm.BackEndIBM.services.HistoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryTest {
	  private HistoryService historyService = new HistoryService();
	  
	  @Test
		public void contextLoads() {
		}
	  
	  /*
	  @Test public void getTest() { 
		  List<History>historys=historyService.get();
		  assertEquals(historys.get(0).getDescription(),"Consumo1");
	  }
	  
	  @Test public void getIDTest() { 
		  History card=historyService.getID(2L);
		  assertEquals(card.getDescription(),"Consumo2"); 
	  }
	  
	  @Test public void getAll() { 
		  assertEquals(5, historyService.get().size()); 
	  }*/
}
