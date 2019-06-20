package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

import java.util.Random;


/**
 * модель игры: карта + игрок
 */
public class Model {
    private Grid grid;
    private ViewGameObject hero = new ViewGameObject(CommonController.Settings.HEROROW, CommonController.Settings.HEROCOL);
    private Random rand = new Random();

    public Model() {
        grid = new Grid(CommonController.Settings.ROW, CommonController.Settings.COL);
    }

    public Model(String path) {
        grid = new Grid(path, CommonController.Settings.ROW, CommonController.Settings.COL);
    }

    private boolean isConfused() {
        return rand.nextInt(20) % 10 == 0;
    }

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getCol(), direction, isConfused());
        return this;
    }

    public Grid getGrid() {
        return grid;
    }
}
