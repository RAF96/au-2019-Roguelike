package com.roguelike.softwaredesign.au2019.model;


import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Space;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

public class Grid {
    private int row;
    private int col;
    private GameObject[][] data;

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;

        GameMap gm = new GameMap(CommonController.Settings.BORDER, CommonController.Settings.SPACE, row, col)
//                .generateMap()
                .loadMap("./maps/72484")
                .setHero(CommonController.Settings.HERO, CommonController.Settings.HEROROW, CommonController.Settings.HEROCOL);
        data = GridConverter
                .from2dArray(gm.getMap());
    }

    public ViewGameObject moveHero(int row, int column, String towards) {
        if (data[row][column].isHero()) {
            return moveCell(row, column, towards);
        } else {
            return null;
        }
    }

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

    public char[][] getData() {
        return GridConverter.to2dArray(data);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
