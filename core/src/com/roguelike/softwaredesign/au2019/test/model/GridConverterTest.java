package com.roguelike.softwaredesign.au2019.test.model;

import com.roguelike.softwaredesign.au2019.model.GridConverter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GridConverterTest {
    private static final int size = 5;

    @Test
    public void toAndFrom2dArray() {
        char[][] first = new char[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                first[i][j] = 'w';
            }
        }
        char[][] second = GridConverter.to2dArray(GridConverter.from2dArray(first));
        assertTrue(Arrays.deepEquals(first, second));
    }
}