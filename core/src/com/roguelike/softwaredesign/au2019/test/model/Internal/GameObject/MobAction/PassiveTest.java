package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Passive;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassiveTest {

    @Test
    public void getToward() {
        Action passive = new Passive();
        ViewGameObject hero = new ViewGameObject(1, 0);
        assertEquals(passive.getToward(1, 1, hero), "HERE");

    }
}