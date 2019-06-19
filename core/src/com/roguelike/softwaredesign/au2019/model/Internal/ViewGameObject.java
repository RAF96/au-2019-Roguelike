package com.roguelike.softwaredesign.au2019.model.Internal;

import com.roguelike.softwaredesign.au2019.model.Towards;

public class ViewGameObject {
    private Integer row;
    private Integer col;

    public ViewGameObject(Integer row, Integer column) {
        this.row = row;
        this.col = column;
    }

    public ViewGameObject updateRowCol(String toward) {
        row += Towards.getDeltaRow(toward);
        col += Towards.getDeltaColumn(toward);
        return this;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }
}
