package com.roguelike.softwaredesign.au2019.model.Internal;

import com.roguelike.softwaredesign.au2019.controller.CommonController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

// карта игры
public class GameMap {
    private char border;
    private char space;
    private int row;
    private int col;
    private char[][] data;

    // генерирует карту заданного размера
    // из указанных символов для пустого пространства и границ
    public GameMap(char border, char space, int row, int col) {
        this.border = border;
        this.space = space;
        this.row = row;
        this.col = col;

        data = new char[row][col];
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
                data[j][i] = border;
            }
        }
        generateMap();
    }

    // загружает карту с учётом заданных размеров
    public GameMap(String fileName, char border, char space, int row, int col) {
        this.border = border;
        this.space = space;
        this.row = row;
        this.col = col;

        data = new char[row][col];
        loadMap(fileName);
    }

    private boolean isLocked(int x, int y) {
        return x >= row || y >= col || x < 0 || y < 0 || data[x][y] != border;
    }

    private void randomGenerator(Random rand, int deep, int centralX, int centralY) {
        if (deep == 0) return;
        data[centralX][centralY] = space;
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
        randomGenerator(rand, --deep, x, y);
    }

    private void makeFrame(int x, int y, int rowSize, int colSize, char symb) {
        for (int i = x; i < rowSize; i++) {
            data[i][y] = symb;
            data[i][colSize] = symb;
        }
        for (int j = y; j < colSize + 1; j++) {
            data[x][j] = symb;
            data[rowSize][j] = symb;
        }
    }

    private void frameGenerator(Random rand, int deep) {
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
        makeFrame(x, y, rowSize, colSize, space);
        frameGenerator(rand, --deep);
    }

    private void saveMap() {
        String fileName = CommonController.Settings.MAPSDIR + "/" + (new Random().nextInt(99999) + 10000);
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

    private void generateMap() {
        Random random = new Random();
        frameGenerator(random, 20);
        randomGenerator(random, 300, row / 2, col / 2);
        makeFrame(1, 0, row - 1, col - 1, border);
        saveMap();
    }

    private void loadMap(String fileName) {
        File file = new File(fileName);
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // возвращает созданную карту
    public char[][] getMap() {
        return data;
    }
}
