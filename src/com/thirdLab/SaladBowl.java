package com.thirdLab;

public class SaladBowl extends Plate {

    //region Fields

    private boolean isDeep;
    private float radius;

    //endregion



    //region Class lifecycle

    public SaladBowl()
    {
        super();
        isDeep = false;
        radius = 0;
    }


    public SaladBowl(String manufacturer, String material)
    {
        super(manufacturer, material);
        isDeep = false;
        radius = 0;
    }


    public SaladBowl(String manufacturer, String material, boolean isDeep, float radius)
    {
        super(manufacturer, material);
        this.isDeep = isDeep;
        this.radius = radius;
    }

    //endregion



    //region IObject

    @Override
    public void printInfo() {

    }

    //endregion



    //region IDish

    @Override
    public void smash() {

    }

    //endregion



    //region Public methods

    @Override
    public void makeSound() {
        System.out.print("Hrust");
    }

    //endregion
}


