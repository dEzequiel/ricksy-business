package edu.poniperro.ricksy.business;
import org.junit.Test;
import static org.junit.Assert.*;

public class RickMenuDispatcherTest {

    @Test
    public void RickMenuDispatch() {

        CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
        Receptivo receptivo = new Receptivo();
        RickMenuDispatcher MenuDispatcher = new RickMenuDispatcher();
        
        receptivo.registra(MenuDispatcher);

        receptivo.dispatch(creditCard);

        assertEquals(99, MenuDispatcher.stock());
        assertEquals(2990, creditCard.credit(), 0);
    }
}
