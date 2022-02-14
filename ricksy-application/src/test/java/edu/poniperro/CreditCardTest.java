package edu.poniperro;

import org.junit.Test;

import edu.poniperro.ricksy.business.CreditCard;

import static org.junit.Assert.*;

public class CreditCardTest {
    

    @Test
    public void checkCreditCardInfo() {
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        System.out.println(creditCard.toString());
    }
}
