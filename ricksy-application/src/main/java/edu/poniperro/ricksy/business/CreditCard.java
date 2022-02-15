package edu.poniperro.ricksy.business;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000;
    // private final String SYMBOL;

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public boolean pay(double price) {
        if (price <= this.credit) {
            this.credit -= price;
            return true;
        } else {return false;}
    }

    public double credit() {
        return this.credit;
    }

    public String number() {
        return this.number;
    }

    @Override
    public String toString() {
        StringBuilder creditCardInfo = new StringBuilder();
        creditCardInfo.append("Owner: ").append(this.owner).append("\n");
        creditCardInfo.append("Number: ").append(this.number);
        return creditCardInfo.toString();
    }
}
