package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Action;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Angry;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Funky;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.MobAction.Passive;

import java.util.HashMap;
import java.util.Random;
import java.util.function.BiFunction;


// конвертер char в GameObject
public class GameObjectConverter {
    private static Random rand = new Random();

    private static Action getAction() {
        int act = rand.nextInt(3);
        switch (act) {
            case 0:
                return new Angry();
            case 1:
                return new Passive();
            case 2:
                return new Funky();
        }
        return new Passive();
    }

    private static HashMap<Character, BiFunction<Integer, Integer, GameObject>> factoryGameObject =
            new HashMap<Character, BiFunction<Integer, Integer, GameObject>>() {{
                put(' ', Space::new);
                put('w', (i, j) -> new Border('w', i, j));
                put('@', (i, j) -> new Hero(i, j, 20, 10));
                put('#', (i, j) -> new Mob(getAction(), i, j, 10, 10));
            }};

    // по данному char возвращает конструктор соответствующего GameObject
    public static BiFunction<Integer, Integer, GameObject> fromChar(char c) {
        return factoryGameObject.get(c);
    }
}
