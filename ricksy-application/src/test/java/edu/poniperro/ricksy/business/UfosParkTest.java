package edu.poniperro.ricksy.business;
import org.junit.Test;
import static org.junit.Assert.*;

public class UfosParkTest {

    @Test
    public void checkMapAddingAndSize() {

        UfosPark ufosPark = new UfosPark();
        String[] ufosID = { "unx", "dox", "trex", "quatrex" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }

        assertEquals(4, ufosPark.getFlota().size());
        ufosPark.add("cincox");
        assertEquals(5, ufosPark.getFlota().size());
        
    }

    @Test
    public void checkIfUfoIsAssigned() {
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        CreditCard creditCard2 = new CreditCard("Abradolph Lincler", "12335456");
        UfosPark ufosPark = new UfosPark();
        ufosPark.add("unox");
        ufosPark.add("dox");


        ufosPark.dispatch(creditCard);
        ufosPark.dispatch(creditCard2);


        assertEquals("unox", ufosPark.getUfoOf(creditCard.number()));
        assertEquals("dox", ufosPark.getUfoOf(creditCard2.number()));

    }


    @Test 
    public void checkIfUfoContainsCard() {
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        CreditCard creditCard2 = new CreditCard("Abradolph Lincler", "12335456");

        UfosPark ufosPark = new UfosPark();
        ufosPark.add("unox");
        ufosPark.add("dox");

        ufosPark.dispatch(creditCard);

        assertTrue("No assigned number", ufosPark.containsCard(creditCard.number()));
        assertFalse("Assigned number", ufosPark.containsCard(creditCard2.number()));
    }
    
}
