package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;


// персонаж
public class Mob extends Fighter {
    private Action act;

    public Mob(Action act, int row, int col, int health, int attack) {
        super(row, col, health, attack);
        this.act = act;
    }

    @Override
    public Boolean isMob() {
        return true;
    }

    @Override
    public char toChar() {
        return '#';
    }

    public String getToward(ViewHero hero) {
        return act.getToward(super.getRow(), super.getColumn(), hero);
    }
}
