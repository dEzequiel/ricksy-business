package edu.poniperro;
import org.junit.Test;

import edu.poniperro.ricksy.business.CreditCard;
import edu.poniperro.ricksy.business.UfosPark;

import static org.junit.Assert.*;

public class UfosParkTest {

    @Test
    public void checkMapSize() {
        
        UfosPark ufosPark = new UfosPark();
        String[] ufosID = { "unx", "dox", "trex", "quatrex" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }

        assertEquals(4, ufosPark.getFlota().size());
    }
    
}
