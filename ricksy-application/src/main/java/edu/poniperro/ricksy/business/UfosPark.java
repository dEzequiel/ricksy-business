package edu.poniperro.ricksy.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
            for (String key : this.flota.keySet()) {
                if (this.flota.get(key) == creditCardNumber) {
                    ufoID = key;
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

        // if creditcard already have a ufo assigned, abort mission
        if (!containsCard(creditCard.number())) {
            for(String key : this.flota.keySet()) {
                if(flota.get(key) == null && creditCard.pay(this.fee)) {
                    flota.replace(key, creditCard.number());
                    break;
                }
            }
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
}
