package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Passive implements Action {
    public String getToward(int row, int col, ViewGameObject hero) {
        return "HERE";
    }

    public boolean fight(Fighter iam, Fighter fighter) {
        return fighter.fight(iam);
    }
}
