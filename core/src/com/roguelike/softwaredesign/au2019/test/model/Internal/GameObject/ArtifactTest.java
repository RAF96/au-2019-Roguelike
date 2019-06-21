package com.roguelike.softwaredesign.au2019.test.model.Internal.GameObject;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.Artifact;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtifactTest {

    @Test
    public void isArtifact() {
        assertTrue(new Artifact('!', 1, 1).isArtifact());
    }

    @Test
    public void updatePos() {
        assertEquals(new Artifact('!', 1, 1).updatePos(1, 2).getCol(), 2);
    }

    @Test
    public void toChar() {
        assertEquals(new Artifact('!', 1, 1).toChar(), '!');
    }

    @Test
    public void getRow() {
        assertEquals(new Artifact('!', 1, 2).getRow(), 1);
    }

    @Test
    public void getCol() {
        assertEquals(new Artifact('!', 1, 2).getCol(), 2);
    }
}