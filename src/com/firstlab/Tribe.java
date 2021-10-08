package com.firstlab;

public class Tribe implements IShowable
{
    private int count;
    private String name;
    private boolean isUseFire;



    public Tribe()
    {
        count = 0;
        name = "";
        isUseFire = false;
    }


    public Tribe(int count, String name, boolean isUseFire)
    {
        this.count = count;
        this.name = name;
        this.isUseFire = isUseFire;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setUseFire(boolean useFire) {
        isUseFire = useFire;
    }


    public int getCount() {
        return count;
    }


    public String getName() {
        return name;
    }

    @Override
    public void printInfo() {
        String tribeFire = isUseFire ? "yes" : "no";
        System.out.printf("_Tribe info_\n")
                .printf("Tribe name: %s\n", name)
                .printf("Tribe count: %d\n", count)
                .printf("Does tribe use fire: %s", tribeFire);

    }
}


