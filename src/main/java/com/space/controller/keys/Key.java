package com.space.controller.keys;

import com.space.model.Player;

public abstract class Key {

    protected Player player;

    public Key(Player p) {
        this.player = p;
    }

    public abstract void doAction();
}
