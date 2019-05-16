package com.roguelike.softwaredesign.au2019;


import com.roguelike.softwaredesign.au2019.GameObject.ViewGameObject;

public class Model {
    private Grid grid = new Grid(App.Settings.ROW, App.Settings.COL);
    private ViewGameObject hero = new ViewGameObject(20, 20);

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getColumn(), direction);
        return this;
    }

    public Grid getGrid() {
        return grid;
    }
}
