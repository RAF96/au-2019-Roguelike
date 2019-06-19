package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


// объект "герой"
public class Hero extends Fighter {
    private BonusPower bonus = new BonusPower(0,0);
    private int level = 0;

    public Hero(int row, int column, int health, int attack) {
        super(row, column, health, attack);
    }

    @Override
    public Boolean isHero() {
        return true;
    }

    @Override
    public char toChar() {
        return '@';
    }

    public void dropArtifact() {
        bonus = new BonusPower(0, 0);
    }

    @Override
    public void takeArtifact(Artifact artifact) {
        bonus = artifact.getBonusPower();
    }

    @Override
    public int getHealth() {
        return bonus.getHealth() + this.health;
    }

    @Override
    public int getAttack() {
        return bonus.getAttack() + this.attack;
    }

    public boolean isAlife() {
        return getHealth() > 0;
    }

    public BonusPower getBonusPower() {
        return bonus;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level += 1;
        health += 5;
        attack += 1;
    }
}
