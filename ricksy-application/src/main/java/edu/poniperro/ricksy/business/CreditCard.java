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

    boolean pay(double price) {
        if (price <= this.credit) {
            this.credit -= price;
            return true;
        } else {return false;}
    }

    double credit() {
        return this.credit;
    }

    String number() {
        return this.number;
    }

    String cardOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        StringBuilder creditCardInfo = new StringBuilder();
        creditCardInfo.append("Owner: ").append(this.owner).append("\n");
        creditCardInfo.append("Number: ").append(this.number);
        return creditCardInfo.toString();
    }
}
