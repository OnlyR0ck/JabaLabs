package com.secondLab;

public class Pony extends Toy implements IProduct {

    //region Class lifecycle

    public Pony(int price, String name)
    {
        super(price, name);
    }

    //endregion



    //region IProduct

    @Override
    public int getPrice() {
        return super.getPrice();
    }


    @Override
    public void printInfo() {
        System.out
                .printf("Toy: Pony ")
                .printf("Name: %s ", super.getName())
                .printf("Price: %d$ \n", super.getPrice());
    }

    //endregion
}