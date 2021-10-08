package com.secondLab;

import java.util.LinkedList;
import java.util.List;

public class Customer {
    private List<IProduct> products;

    private int cash;


    public Customer() {
        cash = 0;
    }


    public Customer(int cash) {
        this.cash = cash;
        products = new LinkedList<IProduct>();
    }


    public int getCash() {
        return cash;
    }


    public void setCash(int cash) {
        if (cash < 0) {
            System.out.printf("Cash cannot be negative. Aborting...");
        } else {
            this.cash = cash;
        }
    }


    public void addToProducts(IProduct product) {
        products.add(product);
    }


    public void showProducts()
    {
        int index = 1;
        for (IProduct product : products) {
            System.out.print(index + ". ");
            product.printInfo();
            index++;
        }
    }
}
