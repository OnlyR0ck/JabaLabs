package com.firstlab;

import com.thirdLab.IObject;

public class WriteInfo {
    public static void showInfo(IShowable iShowable)
    {
        iShowable.printInfo();
    }
    public static void showInfo(IObject object) {object.printInfo();}
}
