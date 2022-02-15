package edu.poniperro;

import org.junit.Test;

import edu.poniperro.ricksy.business.CreditCard;
import edu.poniperro.ricksy.business.UfosPark;

import static org.junit.Assert.*;

public class CreditCardTest {
    

    @Test
    public void checkCreditCardInfo() {
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        System.out.println(creditCard.toString());
    }

    @Test
    public void checkIfPaymentIsDone() {

        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        UfosPark ufosPark = new UfosPark();
        String ufosID = "unx";

		ufosPark.add(ufosID);
        
        assertEquals(3000, creditCard.credit(), 0);
        ufosPark.dispatch(creditCard);
        assertEquals(2500, creditCard.credit(), 0);

        // ufosPark.dispatch(creditCard);
        // assertEquals(2500, creditCard.credit(), 0);
    }
}
