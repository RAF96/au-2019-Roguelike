package com.roguelike.softwaredesign.au2019.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.roguelike.softwaredesign.au2019.controller.CommonController;
import com.roguelike.softwaredesign.au2019.model.Grid;
import com.roguelike.softwaredesign.au2019.model.Internal.ViewHero;


/**
 * отбражение игры: входного окна и поля игры
 */
public class CommonView extends Group {

    private final CommonController commonController;
    private Entry entry;
    private GridView gridView;

    public CommonView(CommonController commonController) {
        super();
        this.commonController = commonController;
        this.entry = new Entry(commonController);
        this.gridView = new GridView(commonController);
        addActor(entry);
        addActor(gridView);
    }

    /**
     * отрисовка
     * @param batch
     * @param parentAlpha
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    /**
     * установка карты игры
     * @param grid
     */
    public void set(Grid grid, ViewHero hero) {
        gridView.set(grid, hero);
    }
}
