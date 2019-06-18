package com.roguelike.softwaredesign.au2019.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Grid;


// отбражение игры: входного окна и поля игры
public class CommonView extends Group {

    private final CommonController commonController;
    private Entry entry;
    private Map map;

    public CommonView(CommonController commonController) {
        super();
        this.commonController = commonController;
        this.entry = new Entry(commonController);
        this.map = new Map(commonController);
        addActor(entry);
        addActor(map);
    }

    // отрисовка
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    // установка карты игры
    public void setGrid(Grid grid) {
        map.setGrid(grid);
    }
}
