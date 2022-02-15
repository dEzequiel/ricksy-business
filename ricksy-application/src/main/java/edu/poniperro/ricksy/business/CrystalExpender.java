package edu.poniperro.ricksy.business;

public class CrystalExpender implements GuestDispatcher{
    private int stock;
    private double itemCost;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }
}
