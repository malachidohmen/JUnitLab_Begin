package csc131.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiftCardTest {

	@Test
	 public void getIssuingStore()
	 {
		
	 double balance;
	 GiftCard card;
	 int issuingStore;

	 issuingStore = 1337;
	 balance = 100.00;
	 card = new GiftCard(issuingStore, balance);
	 assertEquals("getIssuingStore()",issuingStore, card.getIssuingStore());
	
	 }
	
	@Test
	 public void getBalance()
	 {
		
	 double balance;
	 GiftCard card;
	 int issuingStore;
	 double tolerance;
	 
	 tolerance = 0.001;
	 issuingStore = 1337;
	 balance = 100.00;
	 
	 card = new GiftCard(issuingStore, balance);
	 assertEquals("getBalance()",
	 issuingStore, card.getIssuingStore(),tolerance);

	 }
	
	@Test
	 public void  deduct_RemainingBalance()
	 {
		
	 double balance = 100;
	 GiftCard card;
	 double cost = 0;
	 int issuingStore = 1337;
	 
	 
	 card = new GiftCard(issuingStore, balance);
	 
	 balance = card.getBalance();
	 
	 String      result;
     for(cost = -50; cost < 100; cost++)
     {
	     if (cost < 0.0)
	     {
	         result = "Invalid Transaction";
	     }
	     else
	     {
	         balance -= cost;
	         
	         if (balance < 0.0)
	         {
	             result = "Amount Due: " + String.format("%6.2f",
	                                                     Math.abs(balance));
	             balance = 0.0;
	         }
	         else
	         {
	             result = "Remaining Balance: " + String.format("%6.2f",
	                                                      Math.abs(balance));
	         }
	     }
	     
		 assertEquals("deduct_RemainingBalance()",result, card.deduct(cost));
		 
     }
     
   }
	
	@Test
	public void constructor_Incorrect_OpeningBalance_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
    public void constructor_IncorrectID_Low() {
        assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
  }
	
    @Test
    public void constructor_IncorrectID_High() {
        assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});

    }
	
	
		
	
	
	
	
	
	
	
	
	
}
