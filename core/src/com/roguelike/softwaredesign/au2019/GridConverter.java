package com.roguelike.softwaredesign.au2019;

import com.roguelike.softwaredesign.au2019.GameObject.GameObject;
import com.roguelike.softwaredesign.au2019.GameObject.GameObjectConverter;

public class GridConverter {

    static public GameObject[][] from2dArray(char [][] data) {
        GameObject [][] result = new GameObject[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            char[] row = data[i];
            for (int j = 0; j < row.length; ++j) {
                result[i][j] = GameObjectConverter.fromChar(row[j]).apply(i, j);
            }
        }
        return result;
    }

    static public char [][] to2dArray(GameObject [][] data) {
        char [][] result = new char[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            GameObject[] row = data[i];
            for (int j = 0; j < row.length; ++j) {
                result[i][j] = data[i][j].toChar();
            }
        }
        return result;
    }
}
