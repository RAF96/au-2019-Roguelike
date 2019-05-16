package com.roguelike.softwaredesign.au2019.GameObject;

public class Border extends GameObject {

    public Border(Integer i, Integer j) {
        super(i, j);
    }

    @Override
    public Boolean isBorder() {
        return true;
    }

    @Override
    public char toChar() {
        return '#';
    }
}
