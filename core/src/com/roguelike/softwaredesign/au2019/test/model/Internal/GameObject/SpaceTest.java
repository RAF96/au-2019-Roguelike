package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Space;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceTest {

    @Test
    public void isSpace() {
        assertTrue(new Space(' ', 1, 1).isSpace());
    }

    @Test
    public void toChar() {
        assertEquals(new Space(' ', 1, 1).toChar(), ' ');
    }
}