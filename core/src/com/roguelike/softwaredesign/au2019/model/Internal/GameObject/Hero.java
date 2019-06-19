package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


import com.roguelike.softwaredesign.au2019.model.Towards;

// объект "герой"
public class Hero extends Fighter {
    private BonusPower bonus = new BonusPower(0,0);

    public Hero(int row, int column, int health, int attack) {
        super(row, column, health, attack);
    }

    @Override
    public Boolean isHero() {
        return true;
    }

    @Override
    public char toChar() {
        return '@';
    }

    public void dropArtefact() {
        bonus = new BonusPower(0, 0);
    }
}
