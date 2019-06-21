package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;


/**
 * объект "герой"
 */
public class Hero extends Fighter implements GameObject {
    private BonusPower bonus = new BonusPower(0,0);
    private int level = 0;
    private char symb;

    public Hero(char symb, int row, int column, int health, int attack) {
        super(row, column, health, attack);
        this.symb = symb;
    }

    @Override
    public Boolean isHero() {
        return true;
    }

    @Override
    public char toChar() {
        return symb;
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
        return bonus.getHealth() + super.getHealth();
    }

    @Override
    public int getAttack() {
        return bonus.getAttack() + super.getAttack();
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
        super.updateHealth(5);
        super.updateAttack(1);
    }
}
