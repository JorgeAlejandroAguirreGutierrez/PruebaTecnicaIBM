package com.backend.ibm.BackEndIBM;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.ibm.BackEndIBM.models.Card;
import com.backend.ibm.BackEndIBM.services.CardService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardTest {
		private CardService cardService = new CardService();
		
		@Test
		public void contextLoads() {
		}
	  
		/*
	  @Test public void getTest() { List<Card>cards=cardService.get();
	  assertEquals(cards.get(0).getNumber(),"1111-1111-1111"); }
	  
	  @Test public void getIDTest() { 
		  Card card=cardService.getID(2L);
		  assertEquals(card.getNumber(),"2222-2222-2222-2222"); 
	  }
	  
	  @Test public void getAll() { 
		  assertEquals(5, cardService.get().size()); 
	  }*/
}
