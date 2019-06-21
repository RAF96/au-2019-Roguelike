package com.roguelike.softwaredesign.au2019.model.Internal;

import com.roguelike.softwaredesign.au2019.model.Towards;

public class ViewGameObject {
    private int row;
    private int col;

    public ViewGameObject(int row, int column) {
        this.row = row;
        this.col = column;
    }

    public ViewGameObject updateRowCol(String toward) {
        row += Towards.getDeltaRow(toward);
        col += Towards.getDeltaColumn(toward);
        return this;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
