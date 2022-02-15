package edu.poniperro.ricksy.business;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    public UfosPark(){};

    public void add(String ufo) {
        // Add key if the key si not present or aims to null.
        this.flota.putIfAbsent(ufo, null);
    }

    public Map<String, String> getFlota() {
        return this.flota;
    }

    public double getFee() {
        return this.fee;
    }

    // sacar ufo de
    public String getUfoOf(String number) {

        String ufoID = null;
    
        if (this.flota.containsValue(number)) {
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                if (entry.getValue() == number) {
                    ufoID = entry.getKey();
                    break;
                }
            }
        }
        return ufoID;
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
