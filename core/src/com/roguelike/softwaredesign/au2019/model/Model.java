package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.SaveLoadData;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;

import java.util.Random;


// модель игры: карта + игрок
public class Model {
    private Grid grid;
    private Random rand = new Random();
    private ViewHero hero;

    public Model() {
        grid = new Grid(CommonController.Settings.ROW, CommonController.Settings.COL);
        hero = grid.getViewHero();
    }

    public Model(String path, boolean isEmpty) {
        grid = new Grid(path, CommonController.Settings.ROW, CommonController.Settings.COL, isEmpty);
        hero = grid.getViewHero();
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

    public void saveLastState() {
        String fileName = CommonController.Settings.GAMEDIR + "/" + "last";
        SaveLoadData.saveData(fileName, grid.getNumRow(), grid.getNumCol(), grid.getData());
    }

    public void heroDropArtifact() {
        hero.dropArtifact();
    }

    public ViewHero getHero() {
        return hero;
    }
}
