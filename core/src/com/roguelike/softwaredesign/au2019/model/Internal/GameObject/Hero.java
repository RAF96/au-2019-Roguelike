package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

public class Hero extends GameObject{

    public Hero(int row, int column) {
        super(row, column);
    }

    @Override
    public Boolean isHero() {
        return true;
    }

    @Override
    public char toChar() {
        return '@';
    }
}
