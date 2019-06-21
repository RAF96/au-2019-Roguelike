package com.roguelike.softwaredesign.au2019.controller.client.cmd;

import com.roguelike.softwaredesign.au2019.model.Model;

public class ClientCommandSaveLastState implements ClientCommand {
    @Override
    public void execute(Model model) {
        model.saveLastState();
    }
}
