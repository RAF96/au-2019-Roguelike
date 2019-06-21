package com.roguelike.softwaredesign.au2019.controller.client.cmd;

import com.roguelike.softwaredesign.au2019.model.Model;

public class ClientCommandMove implements ClientCommand{
    private String towards;
    private Model model;


    public ClientCommandMove(String towards) {
        this.towards = towards;
    }


    @Override
    public void execute(Model model) {
        model.moveHero(towards);
    }
}
