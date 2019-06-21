package com.roguelike.softwaredesign.au2019.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.roguelike.softwaredesign.au2019.controller.client.cmd.ClientCommand;
import com.roguelike.softwaredesign.au2019.controller.client.cmd.ClientCommandDropArtefact;
import com.roguelike.softwaredesign.au2019.controller.client.cmd.ClientCommandMove;
import com.roguelike.softwaredesign.au2019.controller.client.cmd.ClientCommandSaveLastState;
import com.roguelike.softwaredesign.au2019.model.Model;
import com.roguelike.softwaredesign.au2019.view.CommonView;

import java.io.File;


/**
 * класс инициализации и отрисовки игры
 */
public class CommonController extends ApplicationAdapter {
    private Invoker invoker;
    private Model model;
    private CommonView view;
    private Stage stage;

    /**
     * инициализация
     */
    @Override
    public void create() {
        view = new CommonView(this);
        stage = new Stage();
        new File(Settings.MAPSDIR).mkdirs();
        stage.addActor(view);
        Gdx.input.setInputProcessor(stage);
    }

    /**
     * отрисовка сцены
     */
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        if (model != null && model.getHero() != null && model.getHero().isAlife()) {
            ClientCommand cmd = null;
            boolean flag = true;
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                cmd = new ClientCommandMove("LEFT");
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                cmd = new ClientCommandMove("UP");
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                cmd = new ClientCommandMove("RIGHT");
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                cmd = new ClientCommandMove("DOWN");
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                cmd = new ClientCommandSaveLastState();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
                cmd = new ClientCommandDropArtefact();
            } else {
                flag = false;
            }
            if (flag) {
                invoker.execute(cmd);
                view.set(model.getGrid(), model.getHero());
            }
        }
    }

    /**
     * генерация карты при нажати на кнопку Generate Map
     */
    public void generateMap() {
        model = new Model();
        invoker = new Invoker(model);
        view.set(model.getGrid(), model.getHero());
    }

    /**
     * загрузка карты при нажати на кнопку Load Map
     * @param path
     */
    public void loadMapFromPath(String path) {
        model = new Model(path, true);
        invoker = new Invoker(model);
        view.set(model.getGrid(), model.getHero());
    }

    public void loadGameFromPath(String path) {
        model = new Model(path, false);
        invoker = new Invoker(model);
        view.set(model.getGrid(), model.getHero());
    }

    /**
     * константы игры
     */
    public static class Settings {
        public static int ROWELEM = 15;
        public static int COLELEM = 15;

        public static int ROWVIEWHERO = 10;
        public static int ROW = Gdx.graphics.getHeight() / ROWELEM + 1 - ROWVIEWHERO;
        public static int COL = Gdx.graphics.getWidth() / COLELEM + 1;

        public static String MAPSDIR = "./maps";
        public static String GAMEDIR = "./games";

        public static char BORDER = 'w';
        public static char SPACE = ' ';
        public static char HERO = '@';
        public static char MOB = '#';
        public static char ARTEFACT = '+';

        public static int HEROROW = 20;
        public static int HEROCOL = 20;

        public static int MOBSNUM = 40;
        public static final int ARTIFACTSUM = 5;
    }
}