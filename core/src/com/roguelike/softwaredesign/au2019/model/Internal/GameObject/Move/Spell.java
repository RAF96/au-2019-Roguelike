package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

import java.util.*;


public class Spell extends ConfuseMove {
    private Random rand = new Random();
    private Map<String, List<String>> confuseMap;

    public Spell(Movable movable) {
        super(movable);

        confuseMap = new HashMap<>();
        String[] upDown = {"UP", "DOWN", "HERE"};
        String[] leftRight = {"LEFT", "RIGHT", "HERE"};
        confuseMap.put("LEFT", Arrays.asList(upDown));
        confuseMap.put("RIGHT", Arrays.asList(upDown));
        confuseMap.put("UP", Arrays.asList(leftRight));
        confuseMap.put("DOWN", Arrays.asList(leftRight));
    }

    private String getNextStep(String toward) {
        return confuseMap.get(toward).get(rand.nextInt(3));
    }

    @Override
    public ViewGameObject nextPos(String toward) {
        return super.nextPos(toward).updateRowCol(getNextStep(toward));
    }
}
