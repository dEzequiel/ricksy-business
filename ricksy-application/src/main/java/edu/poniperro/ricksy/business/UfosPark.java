package edu.poniperro.ricksy.business;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee;
    private final Map<String, String> flota = new HashMap<String, String>();

    public UfosPark(){};

    public void add(String ufo) {
        // Add key if the key si not present or aims to null.
        this.flota.putIfAbsent(ufo, null);
    }

    public Map<String, String> getFlota() {
        return this.flota;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        creditCard.pay(this.fee);
    }
}
