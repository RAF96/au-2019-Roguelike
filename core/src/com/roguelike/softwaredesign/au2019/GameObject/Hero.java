package com.roguelike.softwaredesign.au2019.GameObject;

public class Hero extends GameObject{

    public Hero(int row, int column) {
        super(row, column);
    }

    @Override
    public char toChar() {
        return '@';
    }

    @Override
    public Boolean isHero() {
        return true;
    }
}
