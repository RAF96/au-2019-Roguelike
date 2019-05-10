package com.roguelike.softwaredesign.au2019;


import com.roguelike.softwaredesign.au2019.Internal.GameMap;

public class Grid {
    private int row;
    private int col;
    private char[][] data;

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
//        data = new GameMap().generateMap(row, col);
        data = new GameMap().loadMap("./maps/29858");
    }

    public char[][] getData() {
        return data;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
