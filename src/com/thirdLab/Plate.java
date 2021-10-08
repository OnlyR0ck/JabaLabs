package com.thirdLab;

public abstract class Plate implements IDish, IObject {
    //region Fields

    private String manufacturer;
    private String material;

    //endregion



    //region Properties

    public String getManufacturer() {
        return manufacturer;
    }


    public String getMaterial() {
        return material;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //endregion



    //region Class lifecycle

    public Plate()
    {
        manufacturer = "N/A";
        material = "N/A";
    }


    public Plate(String material)
    {
        manufacturer = "N/A";
        this.material = material;
    }


    public Plate(String material, String manufacturer)
    {
        this.manufacturer = manufacturer;
        this.material = material;
    }

    //endregion


    //region Public methods

    public abstract void makeSound();

    //endregion
}


