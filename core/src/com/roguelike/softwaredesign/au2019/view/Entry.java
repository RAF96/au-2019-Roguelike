package com.roguelike.softwaredesign.au2019.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.roguelike.softwaredesign.au2019.controller.CommonController;

import java.io.File;


// отображает входное окно (меню)
public class Entry extends Group {
    private TextField error;
    private TextField path;
    private Button generate;
    private Button loadMap;
    private Button loadLast;


    public Entry(CommonController commonController) {
        super();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        style.fontColor = new Color(1, 1, 1, 1);
        style.checkedFontColor = new Color(1, 1, 1, 1);
        style.checkedOverFontColor = new Color(1, 1, 1, 1);
        style.downFontColor = new Color(1, 1, 1, 1);
        generate = new TextButton("Generate map", style);
        generate.setPosition(200, 220);
        generate.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                commonController.generateMap();
                Entry.this.addAction(Actions.removeActor(Entry.this));
                super.clicked(event, x, y);
            }
        });
        addActor(generate);

        TextField.TextFieldStyle errorStyle = new TextField.TextFieldStyle();
        errorStyle.font = style.font;
        errorStyle.fontColor = new Color(1, 0, 0, 1);
        error = new TextField("", errorStyle);
        error.setPosition(200, 120);
        addActor(error);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = style.font;
        textFieldStyle.fontColor = new Color(1, 1, 0, 1);
        path = new TextField("/Write/path/here", textFieldStyle);
        path.setPosition(200, 160);
        addActor(path);

        loadMap = new TextButton("Load map", style);
        loadMap.setPosition(200, 180);
        loadMap.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String text = path.getText();
                boolean fileExist = new File(text).isFile();
                if (!fileExist) {
                    error.setText("The path doesn't exist");
                    return ;
                }
                commonController.loadMapFromPath(text);
                Entry.this.addAction(Actions.removeActor(Entry.this));
                super.clicked(event, x, y);
            }
        });
        addActor(loadMap);

        loadLast = new TextButton("Load last game", style);
        loadLast.setPosition(200, 140);
        loadLast.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String text = "maps/last";
                boolean fileExist = new File(text).isFile();
                if (!fileExist) {
                    error.setText("There isn't last game");
                    return ;
                }
                commonController.loadMapFromPath(text);
                Entry.this.addAction(Actions.removeActor(Entry.this));
                super.clicked(event, x, y);
            }
        });
        addActor(loadLast);
    }

    // отрисовка
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
