package com.roguelike.softwaredesign.au2019.Internal.GameObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.ObjIntConsumer;


public class GameObjectConverter {
    private static HashMap<Character, BiFunction<Integer, Integer, GameObject>> factoryGameObject =
        new HashMap<Character, BiFunction<Integer, Integer, GameObject>>(){{
            put(' ', Space::new);
            put('#', (i, j) -> new Border('#', i, j));
            put('@', Hero::new);
    }};


    public static BiFunction<Integer, Integer, GameObject> fromChar(char c) {
        return factoryGameObject.get(c);
    }

}
