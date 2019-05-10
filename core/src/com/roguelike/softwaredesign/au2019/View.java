package com.roguelike.softwaredesign.au2019;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class View {
    private SpriteBatch batch;
    private BitmapFont font;

    public View() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.GREEN);
    }

    public void render(Grid grid) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int row = grid.getRow();
        int col = grid.getCol();
        char[][] data = grid.getData();
        int rowElement = App.Settings.ROWELEM;
        int colElement = App.Settings.COLELEM;

        batch.begin();
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
                font.draw(batch, Character.toString(data[j][i]), i * colElement, j * rowElement);
            }
        }
        batch.end();
    }
}
