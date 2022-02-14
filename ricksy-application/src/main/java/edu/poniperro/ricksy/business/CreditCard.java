package edu.poniperro.ricksy.business;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000;
    // private final String SYMBOL;
    
    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }
}
