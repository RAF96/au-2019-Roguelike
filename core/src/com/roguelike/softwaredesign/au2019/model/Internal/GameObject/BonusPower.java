package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import java.util.Random;

public class BonusPower {
    private int bonusHealh;
    private int bonusAttack;
    private static Random random = new Random();
    static private int MAX_BONUS_HEALTH = 5;
    static private int MAX_BONUS_ATTACK = 5;

    BonusPower() {
        bonusHealh += random.nextInt(MAX_BONUS_HEALTH);
        bonusAttack += random.nextInt(MAX_BONUS_ATTACK);
    }

    BonusPower(int health, int attack) {
        bonusHealh += health % MAX_BONUS_HEALTH;
        bonusAttack += attack % MAX_BONUS_ATTACK;
    }

    public int getHealth() {
        return bonusHealh;
    }
    public int getAttack() {
        return bonusAttack;
    }
}
