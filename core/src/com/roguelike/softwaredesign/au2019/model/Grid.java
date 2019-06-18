package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Space;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


// карта игры
public class Grid {
    private int row;
    private int col;
    private GameObject[][] data;

    // инициализация карты сгенерированными границами
    public Grid(int row, int col) {
        this.row = row;
        this.col = col;

        char[][] gameMap = new GameMap(CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col).getMap();
        gameMap[CommonController.Settings.HEROROW][CommonController.Settings.HEROCOL] = CommonController.Settings.HERO;
        data = GridConverter.from2dArray(gameMap);
    }

    // инициализация карты границами, загруженными из файла
    public Grid(String path, int row, int col) {
        this.row = row;
        this.col = col;

        char[][] gameMap = new GameMap(path, CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col).getMap();
        gameMap[CommonController.Settings.HEROROW][CommonController.Settings.HEROCOL] = CommonController.Settings.HERO;
        data = GridConverter.from2dArray(gameMap);
    }

    // передвижение героя
    public ViewGameObject moveHero(int row, int column, String towards) {
        if (data[row][column].isHero()) {
            return moveCell(row, column, towards);
        } else {
            return null;
        }
    }

    // передвижение объектов карты
    public ViewGameObject moveCell(int row, int column, String towards) {
        int newRow = row + Towards.getDeltaRow(towards);
        int newColumn = column + Towards.getDeltaColumn(towards);
        if (data[newRow][newColumn].isSpace()) {
            GameObject new_obj = data[row][column].move(towards);
            data[row][column] = new Space(row, column);
            data[newRow][newColumn] = new_obj;
            return new_obj.getView();
        }
        return data[row][column].getView();
    }

    // перевести объекты карты в массив char'ов
    public char[][] getData() {
        return GridConverter.to2dArray(data);
    }

    // вернуть высоту
    public int getRow() {
        return row;
    }

    // вернуть ширину
    public int getCol() {
        return col;
    }
}
