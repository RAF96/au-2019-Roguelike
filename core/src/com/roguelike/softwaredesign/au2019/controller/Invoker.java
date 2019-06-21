package com.roguelike.softwaredesign.au2019.controller;

import com.roguelike.softwaredesign.au2019.controller.client.cmd.ClientCommand;
import com.roguelike.softwaredesign.au2019.model.Model;

public class Invoker {

    private final Model model;

    Invoker(Model model) {
        this.model = model;
    }

    public void execute(ClientCommand cmd) {
        cmd.execute(model);
    }
}
