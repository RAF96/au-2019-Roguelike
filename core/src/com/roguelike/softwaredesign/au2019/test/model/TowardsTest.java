package com.roguelike.softwaredesign.au2019.test.model;

import com.roguelike.softwaredesign.au2019.model.Towards;
import org.junit.Test;

import static org.junit.Assert.*;

public class TowardsTest {

    @Test
    public void testRow() {
        assertEquals(Towards.getDeltaRow("LEFT"), new Integer(0));
        assertEquals(Towards.getDeltaRow("RIGHT"), new Integer(0));
        assertEquals(Towards.getDeltaRow("UP"), new Integer(1));
        assertEquals(Towards.getDeltaRow("DOWN"), new Integer(-1));
    }

    @Test
    public void testColumn() {
        assertEquals(Towards.getDeltaColumn("LEFT"), new Integer(-1));
        assertEquals(Towards.getDeltaColumn("RIGHT"), new Integer(1));
        assertEquals(Towards.getDeltaColumn("UP"), new Integer(0));
        assertEquals(Towards.getDeltaColumn("DOWN"), new Integer(0));
    }
}