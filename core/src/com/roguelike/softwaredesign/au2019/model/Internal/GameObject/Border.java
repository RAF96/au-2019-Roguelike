package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


/**
 * объект "препятствие"
 */
public class Border extends GameObject {
    private char symb;

    public Border(char symb, int row, int col) {
        super(row, col);
        this.symb = symb;
    }

    @Override
    public Boolean isBorder() {
        return true;
    }

    @Override
    public char toChar() {
        return symb;
    }
}
