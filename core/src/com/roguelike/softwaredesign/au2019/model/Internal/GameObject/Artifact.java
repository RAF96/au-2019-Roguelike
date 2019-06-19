package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


// объект "артефакт"
public class Artifact implements GameObject {
    private char symb;
    private int row;
    private int col;
    private BonusPower bonus = new BonusPower();

    public Artifact(char symb, int row, int col) {
        this.symb = symb;
        this.row = row;
        this.col = col;
    }

    @Override
    public Boolean isArtifact() {
        return true;
    }

    @Override
    public GameObject updatePos(int newRow, int newCol) {
        row = newRow;
        col = newCol;
        return this;
    }

    @Override
    public char toChar() {
        return symb;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    public BonusPower getBonusPower() {
        return bonus;
    }
}
