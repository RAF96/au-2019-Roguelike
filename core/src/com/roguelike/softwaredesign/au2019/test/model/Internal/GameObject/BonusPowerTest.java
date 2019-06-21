package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.BonusPower;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonusPowerTest {

    @Test
    public void getHealth() {
        assertEquals(new BonusPower(1, 2).getHealth(), 1);
    }

    @Test
    public void getAttack() {
        assertEquals(new BonusPower(1, 2).getAttack(), 2);
    }
}