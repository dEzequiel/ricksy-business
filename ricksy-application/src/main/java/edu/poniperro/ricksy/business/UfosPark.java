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
