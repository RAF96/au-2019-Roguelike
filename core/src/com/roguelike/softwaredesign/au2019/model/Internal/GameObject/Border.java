package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


/**
 * объект "препятствие"
 */
public class Border implements GameObject {
    private char symb;
    private int row;
    private int col;

    public Border(char symb, int row, int col) {
        this.symb = symb;
        this.row = row;
        this.col = col;
    }

    @Override
    public GameObject updatePos(int newRow, int newCol) {
        row = newRow;
        col = newCol;
        return this;
    }

    @Override
    public Boolean isBorder() {
        return true;
    }

    @Override
    public char toChar() {
        return symb;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }
}
