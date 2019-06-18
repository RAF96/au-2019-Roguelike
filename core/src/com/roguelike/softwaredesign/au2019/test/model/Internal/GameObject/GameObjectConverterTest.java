package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObjectConverter;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameObjectConverterTest {

    @Test
    public void fromChar() {
        assertTrue(GameObjectConverter.fromChar(' ').apply(1, 1).isSpace());
    }
}