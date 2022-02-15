package edu.poniperro.ricksy.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UfosPark implements GuestDispatcher{
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    UfosPark(){};

    void add(String ufo) {
        // Add key if the key si not present or aims to null.
        this.flota.putIfAbsent(ufo, null);
    }

    Map<String, String> getFlota() {
        return this.flota;
    }

    double getFee() {
        return this.fee;
    }

    // sacar ufo de
    String getUfoOf(String creditCardNumber) {

        String ufoID = null;
    
        if (containsCard(creditCardNumber)) {
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                if (entry.getValue() == creditCardNumber) {
                    ufoID = entry.getKey();
                    break; // finish loop and go to return
                }
            }
        }
        return ufoID;
    }

    boolean containsCard(String creditCardNumber) {
        if(this.flota.containsValue(creditCardNumber)) {
            return true;
        } else {return false;}
    }

   Collection<String> cardNumbers() {
        return this.flota.values();
    }

    // pago y reserva
    @Override
    public void dispatch(CreditCard creditCard) {

        //create map entyr, key/value, to insert into flota
        Map.Entry<String, String> ufo = null;

        // if creditcard already have a ufo assigned, abort mission
        if (!this.flota.containsValue(creditCard.number())) {
            for(Map.Entry<String, String> entry : this.flota.entrySet()) {
                if(entry.getValue() == null) {
                    ufo = entry;
                    break;
                }
            }
        }

        if (ufo != null && creditCard.pay(this.fee)) {
            this.flota.put(ufo.getKey(), creditCard.number());
        }


    }

    @Override
    public String toString()  {
        StringBuilder output = new StringBuilder();

        output.append("[ ");
        for(Map.Entry<String, String> entry : this.flota.entrySet()) {
            output.append(entry.getKey()).append(",");}
        output.append(" ]");


        return output.toString();
    }


    // public static void main(String [] args) {
    //     UfosPark ufosPark = new UfosPark();
        
    //     String ufosID = "unx";
    //     ufosPark.add(ufosID);
    //     CreditCard abradolph = new CreditCard("Abradolph Lincler", "1233545");

    //     ufosPark.dispatch(abradolph);
    //     System.err.println(ufosPark);
    //     System.out.println(ufosPark.getUfoOf(abradolph));
    // }
}
