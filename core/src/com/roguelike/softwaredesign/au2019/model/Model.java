package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;


// модель игры: карта + игрок
public class Model {
    private Grid grid;
    private ViewHero hero;

    public Model() {
        grid = new Grid(CommonController.Settings.ROW, CommonController.Settings.COL);
        hero = grid.getViewHero();
    }

    public Model(String path) {
        grid = new Grid(path, CommonController.Settings.ROW, CommonController.Settings.COL);
        hero = grid.getViewHero();
    }

    public Model moveHero(String direction) {
        hero = grid.moveHero(hero.getRow(), hero.getColumn(), direction);
        return this;
    }

    public Grid getGrid() {
        return grid;
    }

    public void saveLastState() { // MOCK for plurial
    }

    public void heroDropArtefact() {
        hero.dropArtefact();
    }
}
