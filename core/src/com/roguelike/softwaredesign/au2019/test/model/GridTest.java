package com.roguelike.softwaredesign.au2019.test.model;

import com.roguelike.softwaredesign.au2019.model.Grid;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void testSizeGrid() {
        Grid grid = new Grid(5, 5);
        char[][] data = grid.getData();
        assertEquals(data.length, 5);
        assertEquals(data[0].length, 5);
    }
}