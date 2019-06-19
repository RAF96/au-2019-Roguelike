package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

// класс всех персонажей
public abstract class Fighter extends GameObject {
    protected int health;
    protected int attack;

    public Fighter(int row, int col, int health, int attack) {
        super(row, col);
        this.health = health;
        this.attack = attack;
    }

    public boolean fight(Fighter fighter) {
        while (true) {
            fighter.updateHealth(-attack);
            if (fighter.getHealth() > 0) {
                updateHealth(-fighter.getAttack());
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

    public void takeArtifact(Artifact artifact) {
    }
}
