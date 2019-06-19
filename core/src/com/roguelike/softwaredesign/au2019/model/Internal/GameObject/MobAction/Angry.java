package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Angry implements Action {
    public String getToward(int row, int col, ViewGameObject hero) {
        int deltaRow = row - hero.getRow();
        int deltaCol = col - hero.getCol();
        if (Math.abs(deltaRow) > Math.abs(deltaCol)) {
            if (deltaRow < 0) {
                return "UP";
            } else {
                return "DOWN";
            }
        } else {
            if (deltaCol < 0) {
                return "RIGHT";
            } else {
                return "LEFT";
            }
        }
    }
}
