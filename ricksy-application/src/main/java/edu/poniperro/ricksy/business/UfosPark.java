package edu.poniperro.ricksy.business;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee;
    private final Map<String, String> flota = new HashMap<>();

    UfosPark(){};

    @Override
    public void dispatch(CreditCard creditCard) {
        creditCard.pay(this.fee);
    }
}
