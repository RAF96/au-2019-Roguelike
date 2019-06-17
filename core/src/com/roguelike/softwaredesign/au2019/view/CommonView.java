package com.roguelike.softwaredesign.au2019.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Grid;

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

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void setGrid(Grid grid) {
        map.setGrid(grid);
    }
}
