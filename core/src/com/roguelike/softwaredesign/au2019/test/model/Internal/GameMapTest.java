package com.roguelike.softwaredesign.au2019.test.model.Internal;

import com.roguelike.softwaredesign.au2019.model.Internal.GameMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {

    @Test
    public void testGetMap() {
        assertNotNull(new GameMap('w', ' ', 5, 5).getMap());
    }

}