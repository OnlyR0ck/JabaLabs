package com.thirdLab;

public class Platter extends Plate {

    //region Fields

    private boolean isDeep;
    private float radius;

    //endregion



    //region Properties

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public String getMaterial() {
        return super.getMaterial();
    }


    public float getRadius() {
        return radius;
    }

    public boolean IsDeep(){
        return isDeep;
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
        System.out.print("Bdusch");
    }

    //endregion



    //region Public methods

    @Override
    public void makeSound() {
        System.out.print("Bzdun'");
    }

    //endregion
}


