package edu.poniperro.ricksy.business;
import org.junit.Test;
import static org.junit.Assert.*;

public class CrystalExpenderTest {
    
    @Test
    public void checkIfStockDecreaseAndCreditDecrease() {
        CrystalExpender expender = new CrystalExpender(3, 50);
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        
        expender.dispatch(creditCard);

        assertEquals(2, expender.stock());
        assertEquals(2950, creditCard.credit(), 0);

        expender.dispatch(creditCard);
        expender.dispatch(creditCard);

        assertEquals(0, expender.stock());
    }
}
