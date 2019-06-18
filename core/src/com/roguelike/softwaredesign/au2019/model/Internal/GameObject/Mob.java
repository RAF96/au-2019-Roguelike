package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

public class Mob extends GameObject {
    public Mob(int row, int col) {
        super(row, col);
    }

    @Override
    public Boolean isBorder() {
        return false;
    }

    @Override
    public char toChar() {
        return '%';
    }
}
