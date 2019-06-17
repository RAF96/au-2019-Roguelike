package com.roguelike.softwaredesign.au2019.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Grid;

public class Map extends Group {

    private Grid grid;

    public Map(CommonController commonController) {
        super();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (grid != null) {
            render(batch);
        }
    }

    private void render(Batch batch) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int row = grid.getRow();
        int col = grid.getCol();
        char[][] data = grid.getData();
        int rowElement = CommonController.Settings.ROWELEM;
        int colElement = CommonController.Settings.COLELEM;

        BitmapFont font = new BitmapFont();
        font.setColor(Color.GREEN);

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
                font.draw(batch, Character.toString(data[j][i]), i * colElement, j * rowElement);
            }
        }
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
