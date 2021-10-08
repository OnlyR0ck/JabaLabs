package com.thirdLab;

public class Pot implements IDish {

    //region Fields

    private final float weight;

    //endregion



    //region Class lifecycle

    public Pot()
    {
        weight = 10;
    }


    public Pot(float weight)
    {
        this.weight = weight;
    }

    //endregion



    //region IDish

    @Override
    public void smash() {

    }

    //endregion



    //region Public methods

    public void Strike()
    {
        System.out.print("Bdum");
    }

    //endregion
}
