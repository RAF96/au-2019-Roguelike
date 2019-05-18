package com.roguelike.softwaredesign.au2019;


import com.roguelike.softwaredesign.au2019.Internal.GameObject.*;
import com.roguelike.softwaredesign.au2019.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.Internal.GameMap;

public class Grid {
    private int row;
    private int col;
    private GameObject[][] data;

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;

        GameMap gm = new GameMap(App.Settings.BORDER, App.Settings.SPACE, row, col)
//                .generateMap()
                .loadMap("./maps/72484")
                .setHero(App.Settings.HERO, App.Settings.HEROROW, App.Settings.HEROCOL);
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
        int new_row = row + Towards.getDeltaRow(towards);
        int new_column = column + Towards.getDeltaColumn(towards);
        if (data[new_row][new_column].isSpace()) {
            GameObject new_obj = data[row][column].move(towards);
            data[row][column] = new Space(row, column);
            data[new_row][new_column] = new_obj;
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
