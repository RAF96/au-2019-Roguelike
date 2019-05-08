package com.roguelike.softwaredesign.au2019;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class View {
    private SpriteBatch batch;
    private BitmapFont font;
    static float w, h;
    static float w_element, h_element;

    {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        w_element = 80;
        h_element = 80;
    }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
    }

    public void render(Grid grid) {
        ArrayList<ArrayList<Integer>> arrays = grid.to2dArray();
        _render(arrays);
    }

    private void _render(ArrayList<ArrayList<Integer>> grid) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < grid.size(); i++) {
            ArrayList<Integer> row = grid.get(i);
            for (int j = 0; j < row.size(); j++) {
                Integer element = row.get(j);
                if (element == 0) {
                    font.draw(batch, "#", i * h_element, j * w_element);
                }
            }
        }
        batch.end();
    }
}
