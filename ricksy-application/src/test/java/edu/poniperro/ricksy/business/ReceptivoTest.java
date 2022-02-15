package edu.poniperro.ricksy.business;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceptivoTest {

    @Test
    public void addingOberservers() {
        UfosPark ufosPark = new UfosPark();
        CrystalExpender expender = new CrystalExpender(3, 50);
        Receptivo receptivo = new Receptivo();  
        
        receptivo.registra(ufosPark);
        receptivo.registra(expender);

        assertEquals(2, receptivo.getObservers());
    }

    @Test
    public void dispatchObservers() {

        UfosPark ufosPark = new UfosPark();
        ufosPark.add("unox");

        CrystalExpender expender = new CrystalExpender(3, 50);
        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        Receptivo receptivo = new Receptivo();  
        
        receptivo.registra(ufosPark);
        receptivo.registra(expender);

        receptivo.dispatch(creditCard);

        assertEquals(2, expender.stock());
        assertTrue("Ufo assigned", ufosPark.containsCard(creditCard.number()));
        assertEquals(2450, creditCard.credit(), 0);
    }
    
}
