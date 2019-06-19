package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


// персонаж
public class Mob extends Fighter {

    private char symb;
    private Action act;

    public Mob(char symb, Action act, int row, int col, int health, int attack) {
        super(row, col, health, attack);
        this.symb = symb;
        this.act = act;
    }

    @Override
    public Boolean isMob() {
        return true;
    }

    @Override
    public char toChar() {
        return symb;
    }

    public String getToward(ViewGameObject hero) {
        return act.getToward(super.getRow(), super.getCol(), hero);
    }
}
