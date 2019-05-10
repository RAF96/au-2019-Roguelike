package com.roguelike.softwaredesign.au2019;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.io.File;


public class App extends ApplicationAdapter {
	private Model model;
	private View view;

	public static class Settings {
		static int COLELEM = 10;
		static int ROWELEM = 12;

		static int ROW= Gdx.graphics.getHeight() / ROWELEM + 1;
		static int COL = Gdx.graphics.getWidth() / COLELEM;

		public static String DIRNAME = "./maps";
	}


	@Override
	public void create () {
		model = new Model();
		view = new View();
		new File(Settings.DIRNAME).mkdirs();
	}

	@Override
	public void render () {
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
		    view.render(model.move("LEFT"));
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			view.render(model.move("UP"));
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			view.render(model.move("RIGHT"));
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			view.render(model.move("DOWN"));
		}
	}
}