package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.*;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.Movable;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.Spell;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

import java.util.Random;


// карта игры
public class Grid {
    private int numRow;
    private int numCol;
    private GameObject[][] data;

    // инициализация карты сгенерированными границами
    public Grid(int row, int col) {
        char[][] gameMap = new GameMap(CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col).getMap();
        initialize(row, col, gameMap);
    }

    // инициализация карты границами, загруженными из файла
    public Grid(String path, int row, int col) {
        char[][] gameMap = new GameMap(path, CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col).getMap();
        initialize(row, col, gameMap);
    }

    private void initialize(int row, int col, char[][] gameMap) {
        numRow = row;
        numCol = col;

        gameMap[CommonController.Settings.HEROROW][CommonController.Settings.HEROCOL] = CommonController.Settings.HERO;

        Random rand = new Random();
        for (int i = 0; i < CommonController.Settings.MOBSNUM; i++) {
            gameMap[rand.nextInt(numRow - 2) + 1][rand.nextInt(numCol - 2) + 1]  = CommonController.Settings.MOB;
        }

        data = GridConverter.from2dArray(gameMap);
    }

    // передвижение героя
    public ViewGameObject moveHero(int row, int col, String towards, boolean isConfused) {
        if (data[row][col].isHero()) {
            System.out.println("HERO----------");
            System.out.println(isConfused);
            Hero hero = (Hero)data[row][col];
            ViewGameObject viewHero;
            if (isConfused) {
                viewHero = moveCell(new Spell(hero), row, col, towards);
            } else {
                viewHero = moveCell(hero, row, col, towards);
            }

            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (data[i][j].isMob()) {
                        Mob mob = (Mob)data[i][j];
                        moveCell(mob, row, col, mob.getToward(viewHero));
                    }
                }
            }
            return viewHero;
        } else {
            return null;
        }
    }

    private boolean isValidPos(int row, int col) {
        return row < numRow && col < numCol && row > 0 && col > 0;
    }

    private boolean isFreeField(int row, int col, int newRow, int newCol) {
        if (data[newRow][newCol].isMob() || data[newRow][newCol].isHero()) {
            System.out.println(data[newRow][newCol].getClass().toString());
            System.out.println("HERE");
            Fighter iam = (Fighter)data[row][col];
            Fighter fighter = (Fighter)data[newRow][newCol];
            return iam.fight(fighter);
        } else {
            return false;
        }
    }

    private ViewGameObject moveCell(Movable movable, int row, int col, String towards) {
        ViewGameObject viewObj = movable.nextPos(towards);
        int newRow = viewObj.getRow();
        int newCol = viewObj.getCol();
        if (isValidPos(newRow, newCol) && (data[newRow][newCol].isSpace() || isFreeField(row, col, newRow, newCol))) {
            GameObject movedObj = data[row][col].updatePos(newRow, newCol);
            data[row][col] = new Space(' ', row, col);
            data[newRow][newCol] = movedObj;
            return movedObj.getView();
        }
        return data[row][col].getView();
    }

    // перевести объекты карты в массив char'ов
    public char[][] getData() {
        return GridConverter.to2dArray(data);
    }

    // вернуть высоту
    public int getNumRow() {
        return numRow;
    }

    // вернуть ширину
    public int getNumCol() {
        return numCol;
    }
}
