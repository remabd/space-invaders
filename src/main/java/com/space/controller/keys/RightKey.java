package com.space.controller.keys;

import com.space.model.Player;

public class RightKey extends Key {

    public RightKey(Player p) {
        super(p);
    }

    @Override
    public void doAction() {
        this.player.move(1f, 0f);
    }
}
