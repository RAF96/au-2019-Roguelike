package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move;

import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

public abstract class ConfuseMove implements Movable {
    protected Movable movable;

    public ConfuseMove(Movable movable) {
        this.movable = movable;
    }

    @Override
    public ViewGameObject nextPos(String toward) {
        return movable.nextPos(toward);
    }
}
