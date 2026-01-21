package com.space.controller.keys;

import com.space.model.Player;

public class SpaceKey extends Key {

    public SpaceKey(Player p) {
        super(p);
    }

    @Override
    public void doAction() {
        this.player.shoot();
    }
}
