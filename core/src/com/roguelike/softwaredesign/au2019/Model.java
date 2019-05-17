package com.roguelike.softwaredesign.au2019;

import com.roguelike.softwaredesign.au2019.Internal.ViewGameObject;


public class Model {
    private Grid grid = new Grid(App.Settings.ROW, App.Settings.COL);
    private ViewGameObject hero = new ViewGameObject(App.Settings.HEROROW, App.Settings.HEROCOL);

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getColumn(), direction);
        return this;
    }

    public Grid getGrid() {
        return grid;
    }
}
