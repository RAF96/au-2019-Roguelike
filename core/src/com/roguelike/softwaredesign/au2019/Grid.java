package com.roguelike.softwaredesign.au2019;


import java.util.ArrayList;


public class Grid {
    static Boolean MOSK = true;
    private static int nrow = 5;
    private static int column = 5;

    public ArrayList<ArrayList<Integer>> to2dArray() {
        if (MOSK) {
            ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < nrow; i++) {
                grid.add(new ArrayList<Integer>());
                for (int j = 0; j < column; j++) {
                    grid.get(grid.size() - 1).add(0);
                }
            }
            return grid;
        } else {
            return null;
        }
    }
}
