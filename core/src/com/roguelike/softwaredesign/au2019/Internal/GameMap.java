package com.roguelike.softwaredesign.au2019.Internal;

import com.roguelike.softwaredesign.au2019.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class GameMap {
    private boolean MOCK = true; // To do

    private class GenMap {
        private int row;
        private int col;
        private char[][] data;

        private GenMap(int row, int col) {
            this.row = row;
            this.col = col;
            data = new char[row][col];
            for (int j = 0; j < row; j++) {
                for (int i = 0; i < col; i++) {
                    data[j][i] = '#';
                }
            }
            frameGenerate(new Random(), 25);
            randomGenerate(new Random(), 500, row / 2, col / 2);
            saveMap();
        }

        private boolean isLocked(int x, int y) {
            return x >= row || y >= col || x < 0 || y < 0 || data[x][y] != '#';
        }

        private void randomGenerate(Random rand, int deep, int centralX, int centralY) {
            if (deep == 0) return;
            data[centralX][centralY] = ' ';
            int x = centralX;
            int y = centralY;
            int num = rand.nextInt(4);
            switch (num) {
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
            while (isLocked(x, y)) {
                x = rand.nextInt(row);
                y = rand.nextInt(col);
            }
            randomGenerate(rand, --deep, x, y);
        }

        private void frameGenerate(Random rand, int deep) {
            if (deep == 0) return;
            int x;
            int y;
            do {
                x = rand.nextInt(row);
                y = rand.nextInt(col);
            } while (isLocked(x, y));
            int rowSize;
            int colSize;
            do {
                rowSize = rand.nextInt(row - x) + x;
                colSize = rand.nextInt(col - y) + y;
            } while (isLocked(rowSize, colSize));
            for (int i = x; i < rowSize; i++) {
                data[i][y] = ' ';
                data[i][colSize] = ' ';
            }
            for (int j = y; j < colSize + 1; j++) {
                data[x][j] = ' ';
                data[rowSize][j] = ' ';
            }
            frameGenerate(rand, --deep);
        }

        private void saveMap() {
            String fileName = App.Settings.DIRNAME + "/" + (new Random().nextInt(99999) + 10000);
            File file = new File(fileName);
            try {
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

        private char[][] getData() {
            return data;
        }
    }

    public char[][] generateMap(int row, int col) {
        return new GenMap(row, col).getData();
    }

    public char[][] loadMap(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream dataIn = new FileInputStream(file);
            int loadRow = dataIn.read();
            int loadCol = dataIn.read();
            char[][] loadData = new char[loadRow][loadCol];
            for (int j = 0; j < loadRow; j++) {
                for (int i = 0; i < loadCol; i++) {
                    loadData[j][i] = (char)dataIn.read();
                }
            }
            if (MOCK) {
                loadData[20][20] = '@'; // It's hero
            }
            return loadData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
