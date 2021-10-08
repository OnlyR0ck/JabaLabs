package com.secondLab;

import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Shop {
    private List<IProduct> productsList;
    private Vector<IProduct> basket;

    private int cash;


    public Shop(HashSet<IProduct> products, int cash) {

        this.productsList = products.stream().toList();
        basket = new Vector<>();
    }


    public void showProducts() {
        int index = 1;
        for (IProduct product : productsList) {
            System.out.print(index + ". ");
            product.printInfo();
            index++;
        }
    }


    public void addProductToBasket(int productIndex) {
        basket.add(productsList.get(productIndex));
    }


    public void showBasket() {
        for (IProduct product : basket) {
            product.printInfo();
        }
    }


    public void clearBasket() {
        basket.clear();
    }


    public void removeProductFromBasket(int productIndex) {
        basket.remove(productIndex);
    }


    public void placeAnOrder(Customer customer) {
        for (IProduct product : basket) {
            if (product.getPrice() > customer.getCash()) {
                System.out.print("Not enough money! Aborting operation...");
            } else {
                customer.setCash(customer.getCash() - product.getPrice());
                cash += product.getPrice();
                customer.addToProducts(product);
            }
        }
    }
}


