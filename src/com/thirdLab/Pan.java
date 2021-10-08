package com.thirdLab;

public class Pan implements IDish {

    //region Fields

    private final float weight;

    //endregion



    //region Class lifecycle

    public Pan()
    {
        weight = 10;
    }


    public Pan(float weight)
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
        System.out.print("Booom");
    }

    //endregion
}

