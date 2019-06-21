package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Funky;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunkyTest {

    @Test
    public void getToward() {
        Action funky = new Funky();
        ViewGameObject hero = new ViewGameObject(1, 0);
        assertEquals(funky.getToward(1, 1, hero), "RIGHT");

    }
}