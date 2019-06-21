package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject.MobAction;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Hero;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Angry;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;
import org.junit.Test;

import static org.junit.Assert.*;

public class AngryTest {

    @Test
    public void getToward() {
        Action angry = new Angry();
        ViewGameObject hero = new ViewGameObject(1, 0);
        assertEquals(angry.getToward(1, 1, hero), "LEFT");

    }
}