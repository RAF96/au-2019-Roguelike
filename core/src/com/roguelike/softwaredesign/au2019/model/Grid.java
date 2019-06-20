package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.*;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.Movable;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.Spell;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

import java.util.*;


/**
 * карта игры
 */
public class Grid {
    private int numRow;
    private int numCol;
    private GameObject[][] data;
    private Set<Mob> mobs;

    /**
     * инициализация карты сгенерированными границами
     * @param row
     * @param col
     */
    public Grid(int row, int col) {
        char[][] gameMap = new GameMap(CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col).getMap();
        initialize(row, col, gameMap);
    }

    /**
     * инициализация карты границами, загруженными из файла
     * @param path
     * @param row
     * @param col
     */
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

        mobs = new HashSet<>();
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (data[i][j].isMob()) {
                    mobs.add((Mob)data[i][j]);
                }
            }
        }
    }

    // передвижение героя
    public ViewGameObject moveHero(int row, int col, String towards, boolean isConfused) {
        if (data[row][col].isHero()) {
            Hero hero = (Hero)data[row][col];
            ViewGameObject viewHero;
            if (isConfused) {
                viewHero = moveCell(new Spell(hero), row, col, towards);
            } else {
                viewHero = moveCell(hero, row, col, towards);
            }

            Set<Mob> newMobs = new HashSet<>();
            for (Mob mob : mobs) {
                ViewGameObject newPos = moveCell(mob, mob.getRow(), mob.getCol(), mob.getToward(viewHero));
                if (newPos != null) {
                    GameObject gameObject = data[newPos.getRow()][newPos.getCol()];
                    if (gameObject.isMob()) {
                        newMobs.add((Mob) gameObject);
                    }
                }
            }
            mobs = newMobs;
            return viewHero;
        } else {
            return null;
        }
    }


    private boolean isValidPos(int row, int col) {
        return row < numRow && col < numCol && row > 0 && col > 0;
    }

    private ViewGameObject moveCell(Movable movable, int row, int col, String towards) {
        ViewGameObject viewObj = movable.nextPos(towards);
        int newRow = viewObj.getRow();
        int newCol = viewObj.getCol();
        if (isValidPos(newRow, newCol)) {
            if (data[newRow][newCol].isSpace()) {
                GameObject movedObj = data[row][col].updatePos(newRow, newCol);
                data[row][col] = new Space(' ', row, col);
                data[newRow][newCol] = movedObj;
                return movedObj.getView();
            }
            if (data[newRow][newCol].isFighter()) {
                Fighter iam = (Fighter)data[row][col];
                Fighter fighter = (Fighter)data[newRow][newCol];
                if (iam.fight(fighter)) {
                    GameObject movedObj = data[row][col].updatePos(newRow, newCol);
                    data[row][col] = new Space(' ', row, col);
                    data[newRow][newCol] = movedObj;
                    return movedObj.getView();
                } else {
                    data[row][col] = new Space(' ', row, col);
                    return null;
                }
            }
        }
        return data[row][col].getView();
    }

    /**
     * перевести объекты карты в массив char'ов
     * @return char[][]
     */
    public char[][] getData() {
        return GridConverter.to2dArray(data);
    }

    /**
     * вернуть высоту
     * @return int
     */
    public int getNumRow() {
        return numRow;
    }

    /**
     * вернуть ширину
     * @return int
     */
    public int getNumCol() {
        return numCol;
    }
}
