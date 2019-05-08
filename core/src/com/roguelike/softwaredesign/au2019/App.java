package com.roguelike.softwaredesign.au2019;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class App extends ApplicationAdapter {
	private Model model;
	private View view;

	@Override
	public void create () {
		model = new Model();
		view = new View();
		view.create();
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
		/*
		batch.begin();
		sprite.draw(batch);
		batch.end();
		 */
	}
}
