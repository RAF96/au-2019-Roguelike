package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.model.Towards;

public abstract class GameObject {
    private Integer row;
    private Integer column;

    GameObject(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Boolean isHero() {
        return false;
    }

    public Boolean isSpace() {
        return false;
    }

    public Boolean isBorder() {
        return false;
    }

    abstract public char toChar();

    public GameObject move(String towards) {
        row += Towards.getDeltaRow(towards);
        column += Towards.getDeltaColumn(towards);
        return this;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public ViewGameObject getView() {
        return new ViewGameObject(getRow(), getColumn());
    }
}
