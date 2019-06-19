package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Angry implements Action {
    public String getToward(int heroRow, int heroCol) {
        return "LEFT";
    }

    public boolean fight(Fighter iam, Fighter fighter) {
        return iam.fight(fighter);
    }
}
