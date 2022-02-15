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

    boolean pay(double price) {
        if (this.credit > price) {
            return true;
        } else {return false;}
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        StringBuilder creditCardInfo = new StringBuilder();
        creditCardInfo.append("Owner: ").append(this.owner).append("\n");
        creditCardInfo.append("Number: ").append(this.number);
        
        return creditCardInfo.toString();
    }

    // public static void main(String [] args) {
    //     CreditCard creditCard = new CreditCard("Abradolph Lincler", "1233545");
    //     System.out.println(creditCard.toString());
    // }
}
