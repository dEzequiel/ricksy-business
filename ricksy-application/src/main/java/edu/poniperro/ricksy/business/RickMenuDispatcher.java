package edu.poniperro.ricksy.business;

public class RickMenuDispatcher implements GuestDispatcher{
    
    private int stock = 100;
    private double itemCost = 10;

    RickMenuDispatcher(){};

    int stock() {
        return this.stock;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        if(stock() <= 0) {
            this.stock = 0;
        } else {
            creditCard.pay(itemCost);
            this.stock -= 1;

        }
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Stock: ").append(stock());
        return output.toString();
    }

}
