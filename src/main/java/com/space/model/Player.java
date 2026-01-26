package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.render.PlayerRender;

public class Player extends Entity {

    public static float PLAYERSPEED = 1f;

    public Player(GameManager bm) {
        super(5, new Position(0f, -27f), bm);
    }

    public void move(float pX, float pY) {
        if (Math.abs(this.position.getX()) > 20f) {
            this.position.move(
                new Position(-this.position.getX(), this.position.getY())
            );
        }
        this.position.move(
            new Position(
                this.position.getX() + pX * Player.PLAYERSPEED,
                this.position.getY() + pY * Player.PLAYERSPEED
            )
        );
        this.render.setPosition(this.position.getX(), this.position.getY());
    }

    public void shoot() {
        Bullet b = new Bullet(
            new Position(this.position.getX(), this.position.getY() + 3f),
            this.gameManager,
            Bullet.BULLET_SOURCE.PLAYER
        );
        this.gameManager.addBullet(b);
    }

    public void loseHp() {
        this.hp--;
        if (this.hp <= 0) {
            this.gameManager.gameOver();
        }
    }

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
