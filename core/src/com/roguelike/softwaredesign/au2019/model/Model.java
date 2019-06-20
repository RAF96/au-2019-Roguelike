package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


/**
 * модель игры: карта + игрок
 */
public class Model {
    private Grid grid;
    private ViewGameObject hero = new ViewGameObject(CommonController.Settings.HEROROW, CommonController.Settings.HEROCOL);

    public Model() {
        grid = new Grid(CommonController.Settings.ROW, CommonController.Settings.COL);
    }

    public Model(String path) {
        grid = new Grid(path, CommonController.Settings.ROW, CommonController.Settings.COL);
    }

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getColumn(), direction);
        return this;
    }

    public Grid getGrid() {
        return grid;
    }
}
