package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

public interface Action {
    String getToward(int heroRow, int heroCol);

    boolean fight(Fighter iam, Fighter fighter);
}
