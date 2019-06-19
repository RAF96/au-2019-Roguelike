package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;


public interface Action {
    String getToward(int row, int col, ViewHero hero);
}
