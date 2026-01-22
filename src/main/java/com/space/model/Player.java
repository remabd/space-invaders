package com.space.model;

import com.space.controller.BulletManager;
import com.space.view.game.MainGame;
import com.space.view.game.render.PlayerRender;

public class Player extends Entity {

    public static float PLAYERSPEED = 1f;

    public Player(BulletManager bm) {
        super(5, new Position(0f, -5f), new Speed(0f, 0f, 0f), bm);
    }

    public void move() {}

    public void resolveDeath() {}

    public void shoot() {}

    public void initRenderer() {
        this.render = new PlayerRender(
            0f,
            -27f,
            Position.DEPTH,
            0f,
            0f,
            0f,
            1f,
            0f,
            0f,
            1f
        );
    }
}
