package com.roguelike.softwaredesign.au2019.model;

import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObject;
import com.roguelike.softwaredesign.au2019.model.Internal.GameObject.GameObjectConverter;


/**
 * конвертер объектов карты в char и обратно
 */
public class GridConverter {

    /**
     * char -> GameObject
     * @param data
     * @return
     */
    static public GameObject[][] from2dArray(char[][] data) {
        GameObject[][] result = new GameObject[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            char[] row = data[i];
            for (int j = 0; j < row.length; ++j) {
                result[i][j] = GameObjectConverter.fromChar(row[j]).apply(i, j);
            }
        }
        return result;
    }

    /**
     * GameObject -> char
     * @param data
     * @return
     */
    static public char[][] to2dArray(GameObject[][] data) {
        char[][] result = new char[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            GameObject[] row = data[i];
            for (int j = 0; j < row.length; ++j) {
                result[i][j] = data[i][j].toChar();
            }
        }
        return result;
    }
}
