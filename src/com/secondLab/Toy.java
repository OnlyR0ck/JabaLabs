package com.secondLab;

public abstract class Toy {

    //region Fields

    private int price;
    private String name;

    //endregion



    //region Class lifecycle

    public Toy(int price, String name)
    {
        this.price = price;
        this.name = name;
    }

    //endregion



    //region Properties

    public int getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }

    //endregion
}
