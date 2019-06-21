package com.roguelike.softwaredesign.au2019.controller.client.cmd;

import com.roguelike.softwaredesign.au2019.model.Model;

public interface ClientCommand {
    void execute(Model model);
}
