package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


/**
 * объект "герой"
 */
public class Hero extends Fighter implements GameObject {
    private char symb;

    public Hero(char symb, int row, int column, int health, int attack) {
        super(row, column, health, attack);
        this.symb = symb;
    }

    @Override
    public Boolean isHero() {
        return true;
    }

    @Override
    public char toChar() {
        return symb;
    }
}
