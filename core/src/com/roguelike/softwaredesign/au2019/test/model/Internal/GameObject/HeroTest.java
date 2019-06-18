package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Hero;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void isHero() {
        assertTrue(new Hero(1, 1).isHero());
    }

    @Test
    public void toChar() {
        assertEquals(new Hero(1, 1).toChar(), '@');
    }
}