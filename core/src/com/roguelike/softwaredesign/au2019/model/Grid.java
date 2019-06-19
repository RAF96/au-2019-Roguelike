package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Mob;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Space;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// карта игры
public class Grid {
    private int numRow;
    private int numCol;
    private GameObject[][] data;
    private List<Mob> mobs = new ArrayList<>();

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
            gameMap[rand.nextInt(numRow - 1) + 1][rand.nextInt(numCol - 1) + 1]  = CommonController.Settings.MOB;
        }


        for (int i = 0; i < CommonController.Settings.ARTEFACTSNUM; i++) {
            gameMap[rand.nextInt(numRow - 1) + 1][rand.nextInt(numCol - 1) + 1] = CommonController.Settings.ARTEFACT;
        }

        data = GridConverter.from2dArray(gameMap);
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (data[i][j].isMob()) {
                    mobs.add((Mob) data[i][j]);
                }
            }
        }
    }

    // передвижение героя
    public ViewGameObject moveHero(int row, int col, String towards) {
        System.out.println(new Integer(row) + " " + new Integer(col) + "\n");
        if (data[row][col].isHero()) {
            for (Mob mob: mobs) {
                moveCell(mob.getRow(), mob.getColumn(), mob.getToward(row, col));
            }
            return moveCell(row, col, towards);
        } else {
            System.out.println("NOT HERO");
            return null;
        }
    }

    private boolean isValidPos(int row, int col) {
        return row < numRow && col < numCol && row > 0 && col > 0;
    }

    // передвижение объектов карты
    public ViewGameObject moveCell(int row, int col, String towards) {
        int newRow = row + Towards.getDeltaRow(towards);
        int newCol = col + Towards.getDeltaColumn(towards);
        if (isValidPos(newRow, newCol) && data[newRow][newCol].isSpace()) {
            GameObject movedObj = data[row][col].move(towards);
            data[row][col] = new Space(row, col);
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
