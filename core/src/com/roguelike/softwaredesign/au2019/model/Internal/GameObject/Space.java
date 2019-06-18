package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


// объект "пустое пространство"
public class Space extends GameObject {

    public Space(int row, int column) {
        super(row, column);
    }

    @Override
    public Boolean isSpace() {
        return true;
    }

    @Override
    public char toChar() {
        return ' ';
    }
}
