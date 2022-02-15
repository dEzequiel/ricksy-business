package edu.poniperro.ricksy.business;

public class CrystalExpender implements GuestDispatcher{
    private int stock;
    private double itemCost;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    int stock() {
        return this.stock;
    }

    @Override
    public void dispatch(CreditCard number) {

        if (number.pay(itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        
        output.append("stock: ").append(stock()).append("\n");
        output.append("cost: ").append(this.itemCost);

        return output.toString();

    }
}
