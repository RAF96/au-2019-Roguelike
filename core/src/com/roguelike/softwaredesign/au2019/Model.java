package com.roguelike.softwaredesign.au2019;

public class Model {
    private static Boolean MOSK = true;

    public Grid move(String direction) {
        if (MOSK) {
            System.out.println(direction);
            return new Grid();
        } else {
            return null;
        }
    }
}
