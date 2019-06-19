package com.roguelike.softwaredesign.au2019.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Grid;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;

import java.util.Map;
import java.util.TreeMap;


// отображает карту игры
public class GridView extends Group {

    private Grid grid;
    private ViewHero hero;

    public GridView(CommonController commonController) {
        super();
    }

    // отрисовка
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



        BitmapFont font = new BitmapFont();
        font.setColor(Color.GREEN);

        drawMap(font, batch);
        drawHero(font, batch);
    }

    private void drawHero(BitmapFont font, Batch batch) {
        int row = CommonController.Settings.ROW + 1;
        int rowElement = CommonController.Settings.ROWELEM;
        if (hero == null || !hero.isAlife()) {
            font.draw(batch, "You are died!", 0, row * rowElement);
            return ;
        }
        Map<String, String> features = new TreeMap<String, String>() {{
            put("Artifact", String.format("health: %d, attack %d",
                                             hero.getBonusPower().getHealth(),
                                             hero.getBonusPower().getAttack()
            ));
            put("Health", Integer.toString(hero.getHealth()));
            put("Attack", Integer.toString(hero.getAttack()));
            put("Level", Integer.toString(hero.getLevel()));
        }};
        for (Map.Entry<String, String> element : features.entrySet()) {
            font.draw(batch,
                      String.format("%s: %s", element.getKey(), element.getValue()),
                      0,
                      row * rowElement
            );
            row++;
        }
    }

    private void drawMap(BitmapFont font, Batch batch) {
        int row = grid.getNumRow();
        int col = grid.getNumCol();
        char[][] data = grid.getData();
        int rowElement = CommonController.Settings.ROWELEM;
        int colElement = CommonController.Settings.COLELEM;
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
                font.draw(batch, Character.toString(data[j][i]), i * colElement, j * rowElement);
            }
        }
    }

    // установка карты
    public void set(Grid grid, ViewHero hero) {
        this.grid = grid;
        this.hero = hero;
    }
}
