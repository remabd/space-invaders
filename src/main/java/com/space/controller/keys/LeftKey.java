package com.space.controller.keys;

import com.space.model.Player;

public class LeftKey extends Key {

    public LeftKey(Player p) {
        super(p);
    }

    @Override
    public void doAction() {
        this.player.move();
    }
}
