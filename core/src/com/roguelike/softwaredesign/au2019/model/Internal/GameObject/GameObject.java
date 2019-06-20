package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;


/**
 * интерфейс всех объектов карты
 */
public interface GameObject {
    default Boolean isSpace() {
        return false;
    }

    default Boolean isBorder() {
        return false;
    }

    default Boolean isFighter() {
        return false;
    }

    default Boolean isHero() {
        return false;
    }

    default Boolean isMob() { return false; }

    default Boolean isArtifact() {
        return false;
    }

    char toChar();

    int getCol();

    int getRow();

    GameObject updatePos(int newRow, int newCol);

    default ViewGameObject getView() {
        return new ViewGameObject(getRow(), getCol());
    }
}
