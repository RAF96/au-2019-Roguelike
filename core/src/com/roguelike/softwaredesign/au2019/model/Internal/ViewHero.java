package com.roguelike.softwaredesign.au2019.model.Internal;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.BonusPower;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Hero;

public class ViewHero {
    /*
            Hero с ограничением на передвижение, так как любое передвижение должно получить approve от Grid
    */
    private Hero hero;

    public ViewHero(Hero hero) {
        this.hero = hero;
    }

    public Integer getRow() {
        return hero.getRow();
    }

    public Integer getColumn() {
        return hero.getColumn();
    }

    public void dropArtifact() {
        hero.dropArtifact();
    }

    public boolean isAlife() {
        return hero.isAlife();
    }

    public int getHealth() {
        return hero.getHealth();
    }

    public int getAttack() {
        return hero.getAttack();
    }

    public BonusPower getBonusPower() {
        return hero.getBonusPower();
    }
}
