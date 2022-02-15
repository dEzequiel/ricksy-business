package edu.poniperro.ricksy.business;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee;
    private final Map<String, String> flota = new HashMap<>();

    public UfosPark(){};

    void add(String ufo) {
        this.flota.putIfAbsent(ufo, null);
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        creditCard.pay(this.fee);
    }
}
