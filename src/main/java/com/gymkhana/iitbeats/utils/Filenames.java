package com.gymkhana.iitbeats.utils;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class Filenames {
    public static final String SHOPS = "shops";
    public static final String MENU = "menu";
    public static final String ORDERS = "orders";
    public static final String BILLS = "bills";

    public static final String getFilename(String name) {
        return name + ".txt";
    }

    public static final String getFilename(String name, Integer tag) {
        return name + "_" + tag + ".txt";
    }
}
