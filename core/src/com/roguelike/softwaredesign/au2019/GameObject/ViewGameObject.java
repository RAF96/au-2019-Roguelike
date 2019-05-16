package com.roguelike.softwaredesign.au2019.GameObject;

public class ViewGameObject {
    private Integer row;
    private Integer column;

    public ViewGameObject(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}
