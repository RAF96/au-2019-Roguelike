package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Funky implements Action {
    public String getToward(int row, int col, ViewGameObject hero) {
        int deltaRow = row - hero.getRow();
        int deltaCol = col - hero.getColumn();
        if (Math.abs(deltaRow) > Math.abs(deltaCol)) {
            if (deltaRow < 0) {
                return "DOWN";
            } else {
                return "UP";
            }
        } else {
            if (deltaCol < 0) {
                return "LEFT";
            } else {
                return "RIGHT";
            }
        }
    }
}
