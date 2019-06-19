package com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Move;


import com.roguelike.softwaredesign.au2019.model.Internal.ViewGameObject;

public interface Movable {
    ViewGameObject nextPos(String toward);
}
