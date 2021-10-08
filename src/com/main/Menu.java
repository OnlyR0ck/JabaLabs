package com.main;

import java.util.List;
import java.util.Scanner;

public class Menu {
    //region Fields

    private List<Consumer> menuCases;

    private int size;
    private boolean isStarted;
    private int pointerToFunc;

    //endregion



    //region Class lifecycle

    public Menu() {

    }

    //endregion



    //region Properties
    public int getSize() {
        return size;
    }
    //endregion



    //region Public methods

    public void start() {
        isStarted = true;
        Scanner userInput = new Scanner(System.in);

        while(isStarted) {
            for( Consumer menuCase : menuCases)
            {
                //
            }
        }
    }

    //endregion
}


interface Consumer<T> {
    void execute(T t);
}
