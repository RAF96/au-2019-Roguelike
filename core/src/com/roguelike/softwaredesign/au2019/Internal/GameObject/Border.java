package com.roguelike.softwaredesign.au2019.Internal.GameObject;

public class Border extends GameObject {
    private char symb;

    public Border(char symb, Integer i, Integer j) {
        super(i, j);
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
