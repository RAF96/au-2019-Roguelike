package com.roguelike.softwaredesign.au2019.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.roguelike.softwaredesign.au2019.controller.CommonController;

import java.util.*;


public class Entry extends Group {
    private final CommonController controller;
    private TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
    private Button generate;
    private Button download;
    TextField textField;

    public Entry(CommonController controller) {
        super();
        this.controller = controller;
        style.font = new BitmapFont();
        style.fontColor = new Color(1, 1, 0, 1);
        style.checkedFontColor = new Color(1, 1, 0, 1);
        style.checkedOverFontColor = new Color(1, 1, 0, 1);
        style.downFontColor = new Color(1, 1, 0, 1);
        generate = new TextButton("Generate map", style);
        generate.setPosition(200, 220);
        generate.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.generateMap();
                Entry.this.addAction(Actions.removeActor(Entry.this));
                super.clicked(event, x, y);
            }
        });
        addActor(generate);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = style.font;
        textFieldStyle.fontColor = new Color(1, 1, 0, 1);

        textField = new TextField("Write path here", textFieldStyle);
        textField.setPosition(200, 180);
        addActor(textField);

        download = new TextButton("Download map", style);
        download.setPosition(200, 200);
        download.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.loadMapFromPath(textField.getText());
                Entry.this.addAction(Actions.removeActor(Entry.this));
                super.clicked(event, x, y);
            }
        });
        addActor(download);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
