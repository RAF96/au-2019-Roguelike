package com.roguelike.softwaredesign.au2019.model.Internal.GameObject;

import javax.swing.*;
import java.util.Random;

public class Artefact extends GameObject {
    private BonusPower bonus = new BonusPower(0, 0);

    public Artefact(int row, int column) {
        super(row, column);
    }

    @Override
    public char toChar() {
        return '+';
    }
}
