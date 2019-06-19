package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Funky implements Action {
    public String getToward(int heroRow, int heroCol) {
        return "RIGHT";
    }

    public boolean fight(Fighter iam, Fighter fighter) {
        return fighter.fight(iam);
    }
}
