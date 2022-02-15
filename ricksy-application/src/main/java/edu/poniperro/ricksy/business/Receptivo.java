package edu.poniperro.ricksy.business;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {

    List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

    void registra(GuestDispatcher observer) {
        observers.add(observer);
    }

    int getObservers() {
        return this.observers.size();
    }

    void dispatch(CreditCard number) {
        for(GuestDispatcher observer : observers) {
            observer.dispatch(number);
        }
    }

}
