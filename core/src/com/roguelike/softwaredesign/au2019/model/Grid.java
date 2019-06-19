package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.*;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.*;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;
import java.util.*;


// карта игры
public class Grid {
    private int step = 0;
    private int numRow;
    private int numCol;
    private GameObject[][] data;
    private Set<Mob> mobs;

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


        for (int i = 0; i < CommonController.Settings.ARTEFACTSNUM; i++) {
            gameMap[rand.nextInt(numRow - 1) + 1][rand.nextInt(numCol - 1) + 1] = CommonController.Settings.ARTEFACT;
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
    public ViewHero moveHero(int row, int col, String towards, boolean isConfused) {
        if (data[row][col].isHero()) {
//            System.out.println("HERO----------");
//            System.out.println(isConfused);
            Hero hero = (Hero) data[row][col];
            ViewGameObject heroPos;
            if (isConfused) {
                heroPos = moveCell(new Spell(hero), row, col, towards);
            } else {
                heroPos = moveCell(hero, row, col, towards);
            }

            Set<Mob> newMobs = new HashSet<>();
            for (Mob mob : mobs) {
                ViewGameObject mobPos = moveCell(mob, mob.getRow(), mob.getCol(), mob.getToward(heroPos));
                if (mobPos != null) {
                    GameObject gameObject = data[mobPos.getRow()][mobPos.getCol()];
                    if (gameObject.isMob()) {
                        newMobs.add((Mob) gameObject);
                    }
                }
            }
            mobs = newMobs;

            if (heroPos != null) {
                ViewHero viewHero = new ViewHero((Hero) data[heroPos.getRow()][heroPos.getCol()]);
                step++;
                if (step % 10 == 0 && viewHero.isAlife()) {
                    ((Hero) data[viewHero.getRow()][viewHero.getCol()]).levelUp();
                }
                if (viewHero.isAlife()) {
                    return viewHero;
                }
            }
        }
        return null;
    }

    private boolean isValidPos(int row, int col) {
        return row < numRow && col < numCol && row > 0 && col > 0;
    }

    private ViewGameObject moveCell(Movable movable, int row, int col, String towards) {
        ViewGameObject viewObj = movable.nextPos(towards);
        int newRow = viewObj.getRow();
        int newCol = viewObj.getCol();
//        System.out.println(movable.getClass() + " " + new Integer(newRow) + " " + new Integer(newCol));
        if (isValidPos(newRow, newCol)) {
            if (data[newRow][newCol].isSpace()) {
                GameObject movedObj = data[row][col].updatePos(newRow, newCol);
                data[row][col] = new Space(' ', row, col);
                data[newRow][newCol] = movedObj;
                return movedObj.getView();
            }

            if (data[newRow][newCol].isArtifact()) {
                Fighter fighter = (Fighter) data[row][col].updatePos(newRow, newCol);
                fighter.takeArtifact((Artifact) data[newRow][newCol]);
                data[row][col] = new Space(' ', row, col);
                data[newRow][newCol] = fighter;
                return fighter.getView();
            }

            if (data[newRow][newCol].isFighter()) {
//                System.out.println("FIGHT!!");
//                System.out.println(data[row][col].getClass().toString() + " " + new Integer(row) + " " + new Integer(col));
//                System.out.println(data[newRow][newCol].getClass().toString() + " " + new Integer(newRow) + " " + new Integer(newCol));
                Fighter iam = (Fighter) data[row][col];
                Fighter fighter = (Fighter) data[newRow][newCol];
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
        return null;
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

    public ViewHero getViewHero() {
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (data[i][j].isHero())
                    return new ViewHero((Hero) data[i][j]);
            }
        }
        return null;
    }
}
