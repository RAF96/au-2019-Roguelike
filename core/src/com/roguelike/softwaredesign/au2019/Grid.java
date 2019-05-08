package com.roguelike.softwaredesign.au2019;


import java.util.ArrayList;
import java.util.stream.IntStream;

public class Grid {
    static Boolean MOSK = true;
    private static int nrow = 5;
    private static int column = 5;

    public ArrayList<ArrayList<Integer>> to2dArray() {
        if (MOSK) {
            ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
            for (int i : IntStream.range(0, nrow).toArray()) {
                grid.add(new ArrayList<>());
                for (int j : IntStream.range(0, nrow).toArray()) {
                    grid.get(grid.size() - 1).add(0);
                }
            }
            return grid;
        } else {
            return null;
        }
    }
}
