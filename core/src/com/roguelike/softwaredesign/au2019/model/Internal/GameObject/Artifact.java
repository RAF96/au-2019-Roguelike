package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import javax.swing.*;
import java.util.Random;

public class Artifact extends GameObject {
    private BonusPower bonus = new BonusPower();

    public Artifact(int row, int column) {
        super(row, column);
    }

    @Override
    public char toChar() {
        return '+';
    }

    @Override
    public Boolean isArtifact() {
        return true;
    }

    public BonusPower getBonusPower() {
        return bonus;
    }
}
