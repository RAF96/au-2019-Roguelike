package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.*;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;

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


        for (int i = 0; i < CommonController.Settings.ARTEFACTSNUM; i++) {
            gameMap[rand.nextInt(numRow - 1) + 1][rand.nextInt(numCol - 1) + 1] = CommonController.Settings.ARTEFACT;
        }

        data = GridConverter.from2dArray(gameMap);
    }

    // передвижение героя
    public ViewHero moveHero(int row, int col, String towards) {
        if (data[row][col].isHero()) {
            ViewHero viewHero = new ViewHero((Hero) data[row][col]);
            boolean flag = moveCell(row, col, towards);
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (data[i][j].isMob()) {
                        Mob mob = (Mob)data[i][j];
                        moveCell(mob.getRow(), mob.getColumn(), mob.getToward(viewHero));
                    }
                }
            }
            if (viewHero.isAlife()) {
                return viewHero;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean isValidPos(int row, int col) {
        return row < numRow && col < numCol && row > 0 && col > 0;
    }

    private boolean isFreeField(int row, int col, int newRow, int newCol) {
        if (data[newRow][newCol].isSpace()) {
            return true;
        }
        if (data[newRow][newCol].isArtifact()) {
            Fighter fighter = (Fighter) data[row][col];
            fighter.takeArtifact((Artifact) data[newRow][newCol]);
            return true;
        }
        if (data[newRow][newCol].isMob() || data[newRow][newCol].isHero()) {
            Fighter iam = (Fighter)data[row][col];
            Fighter fighter = (Fighter)data[newRow][newCol];
            return iam.fight(fighter);
        } else {
            return false;
        }
    }

    private boolean moveCell(int row, int col, String towards) {
        int newRow = row + Towards.getDeltaRow(towards);
        int newCol = col + Towards.getDeltaColumn(towards);
        if (isValidPos(newRow, newCol) && (isFreeField(row, col, newRow, newCol))) {
            GameObject movedObj = data[row][col].move(towards);
            data[row][col] = new Space(row, col);
            data[newRow][newCol] = movedObj;
            return true;
        }
        return false;
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
