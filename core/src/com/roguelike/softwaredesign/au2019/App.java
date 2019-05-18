package com.roguelike.softwaredesign.au2019;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.io.File;


public class App extends ApplicationAdapter {
	private Model model;
	private View view;

	public static class Settings {
		static int ROWELEM = 15;
		static int COLELEM = 15;

		static int ROW = Gdx.graphics.getHeight() / ROWELEM + 1;
		static int COL = Gdx.graphics.getWidth() / COLELEM + 1;

		public static String DIRNAME = "./maps";

		static char BORDER = 'w';
		static char SPACE = ' ';
		static char HERO = '@';

		static int HEROROW = 20;
		static int HEROCOL = 20;
	}


	@Override
	public void create () {
		model = new Model();
		view = new View();
		new File(Settings.DIRNAME).mkdirs();
		view.render(model.getGrid());
	}

	@Override
	public void render () {
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
		    view.render(model.moveHero("LEFT").getGrid());
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			view.render(model.moveHero("UP").getGrid());
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			view.render(model.moveHero("RIGHT").getGrid());
		} else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			view.render(model.moveHero("DOWN").getGrid());
		}
	}
}