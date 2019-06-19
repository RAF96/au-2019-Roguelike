package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;


public class Passive implements Action {
    public String getToward(int row, int col, ViewHero hero) {
        return "HERE";
    }
}
