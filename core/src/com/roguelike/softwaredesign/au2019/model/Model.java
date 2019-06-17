package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


public class Model {
    private Grid grid = new Grid(CommonController.Settings.ROW, CommonController.Settings.COL);
    private ViewGameObject hero = new ViewGameObject(CommonController.Settings.HEROROW, CommonController.Settings.HEROCOL);

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getColumn(), direction);
        return this;
    }

    public Grid getGrid() {
        return grid;
    }
}
