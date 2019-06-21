package com.roguelike.softwaredesign.au2019.model.Internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SaveLoadData {

    static public void saveData(String fileName, int row, int col, char[][] data) {
        File file = new File(fileName);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream dataOut = new FileOutputStream(file);
            dataOut.write(row);
            dataOut.write(col);
            for (int j = 0; j < row; j++) {
                for (int i = 0; i < col; i++) {
                    dataOut.write(data[j][i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static public char[][] loadData(String fileName, int row, int col) {
        File file = new File(fileName);
        try {
            char[][] data = new char[row][col];
            FileInputStream dataIn = new FileInputStream(file);
            int loadRow = dataIn.read();
            int loadCol = dataIn.read();
            for (int j = 0; j < loadRow; j++) {
                if (j >= row) continue;
                for (int i = 0; i < loadCol; i++) {
                    if (i >= col) continue;
                    data[j][i] = (char) dataIn.read();
                }
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
