package com.space.model;

import com.space.controller.BulletManager;
import com.space.view.game.render.PlayerRender;

public class Player extends Entity {

    public static float PLAYERSPEED = 1f;

    public Player(BulletManager bm) {
        super(5, new Position(0f, -27f), new Speed(0f, 0f, 0f), bm);
    }

    public void move(float pX, float pY) {
        this.position.move(
            new Position(
                this.position.getX() + pX * Player.PLAYERSPEED,
                this.position.getY() + pY * Player.PLAYERSPEED
            )
        );
        this.render.setPosition(this.position.getX(), this.position.getY());
    }

    public void resolveDeath() {}

    public void shoot() {}

    public void initRenderer() {
        this.render = new PlayerRender(
            this.position.getX(),
            this.position.getY(),
            0f,
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
