package com.secondLab;

public class Cowboy extends Toy implements IProduct {

    //region Class lifecycle

    public Cowboy(int price, String name) {
        super(price, name);
    }

    //endregion



    //region IProduct
    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void printInfo() {
        System.out
                .printf("Toy: Cowboy ")
                .printf("Name: %s ", super.getName())
                .printf("Price: %d$ \n", super.getPrice());
    }
    //endregion
}