package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move.Movable;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.model.Towards;


// класс всех персонажей
public abstract class Fighter implements GameObject, Movable {

    private int row;
    private int col;

    private int health;
    private int attack;

    public Fighter(int row, int col, int health, int attack) {
        this.row = row;
        this.col = col;

        this.health = health;
        this.attack = attack;
    }

    @Override
    public ViewGameObject nextPos(String toward) {
        return new ViewGameObject(row + Towards.getDeltaRow(toward), col + Towards.getDeltaColumn(toward));
    }

    @Override
    public Boolean isFighter() {
        return true;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public GameObject updatePos(int newRow, int newCol) {
        row = newRow;
        col = newCol;
        return this;
    }

    public boolean fight(Fighter fighter) {
        while (true) {
            fighter.updateHealth(-attack);
            if (fighter.getHealth() > 0) {
                updateHealth(fighter.getAttack());
                if (getHealth() <= 0) {
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void updateHealth(int delta) {
        health += delta;
    }

    public void updateAttack(int delta) {
        attack += delta;
    }
}
