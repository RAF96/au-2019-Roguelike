package com.roguelike.softwaredesign.au2019;


public class Model {
    private Grid grid = new Grid(App.Settings.ROW, App.Settings.COL);
    private static Boolean MOCK = true;

    public Grid move(String direction) {
        if (MOCK) {
            System.out.println(direction);
            return grid;
        } else {
            return null;
        }
    }
}
