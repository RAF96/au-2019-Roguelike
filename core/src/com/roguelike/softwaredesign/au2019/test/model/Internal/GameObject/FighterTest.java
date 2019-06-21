package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Artifact;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Fighter;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Hero;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Mob;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Angry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FighterTest {
    private Fighter hero;
    private Fighter mob;

    @Before
    public void before() {
        this.hero = new Hero('@', 1, 2, 3, 4);
        this.mob = new Mob('#', new Angry(), 1, 2, 3, 4);
    }

    @Test
    public void nextPos() {
        assertEquals(hero.nextPos("LEFT").getCol(), 1);
        assertEquals(mob.nextPos("LEFT").getCol(), 1);
    }

    @Test
    public void isFighter() {
        assertTrue(hero.isFighter());
        assertTrue(mob.isFighter());
    }

    @Test
    public void getRow() {
        assertEquals(hero.getRow(), 1);
        assertEquals(mob.getRow(), 1);
    }

    @Test
    public void getCol() {
        assertEquals(hero.getCol(), 2);
        assertEquals(mob.getCol(), 2);
    }

    @Test
    public void fight() {
        assertTrue(hero.fight(mob));
    }

    @Test
    public void getHealth() {
        assertEquals(hero.getHealth(), 3);
        assertEquals(mob.getHealth(), 3);
    }

    @Test
    public void getAttack() {
        assertEquals(hero.getAttack(), 4);
        assertEquals(mob.getAttack(), 4);
    }

    @Test
    public void takeArtifact() {
        mob.takeArtifact(new Artifact('!', 0, 0));
        assertEquals(mob.getAttack(), hero.getAttack());
        assertEquals(mob.getHealth(), hero.getHealth());
    }
}