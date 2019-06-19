package com.roguelike.softwaredesign.au2019.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.roguelike.softwaredesign.au2019.model.Model;
import com.roguelike.softwaredesign.au2019.view.CommonView;

import java.io.File;


// класс инициализации и отрисовки игры
public class CommonController extends ApplicationAdapter {
    private Model model;
    private CommonView view;
    private Stage stage;

    // инициализация
    @Override
    public void create() {
        view = new CommonView(this);
        stage = new Stage();
        new File(Settings.MAPSDIR).mkdirs();
        stage.addActor(view);
        Gdx.input.setInputProcessor(stage);
        System.out.println(new Integer(Settings.ROW) + " " + new Integer(Settings.COL) + "\n");
    }

    // отрисовка сцены
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            view.setGrid(model.moveHero("LEFT").getGrid());
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            view.setGrid(model.moveHero("UP").getGrid());
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            view.setGrid(model.moveHero("RIGHT").getGrid());
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            view.setGrid(model.moveHero("DOWN").getGrid());
        }
    }

    // генерация карты при нажати на кнопку Generate Map
    public void generateMap() {
        model = new Model();
        view.setGrid(model.getGrid());
    }

    // загрузка карты при нажати на кнопку Load Map
    public void loadMapFromPath(String path) {
        model = new Model(path);
        view.setGrid(model.getGrid());
    }

    // константы игры
    public static class Settings {
        public static int ROWELEM = 15;
        public static int COLELEM = 15;

        public static int ROW = Gdx.graphics.getHeight() / ROWELEM + 1;
        public static int COL = Gdx.graphics.getWidth() / COLELEM + 1;

        public static String MAPSDIR = "./maps";

        public static char BORDER = 'w';
        public static char SPACE = ' ';
        public static char HERO = '@';
        public static char MOB = '#';

        public static int HEROROW = 20;
        public static int HEROCOL = 20;

        public static int MOBSNUM = 10;
    }
}