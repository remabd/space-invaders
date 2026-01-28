package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.MainGame;
import com.space.view.game.render.PlayerRender;

public class Player extends Entity {

    public static float PLAYERSPEED = 1f;

    public Player(GameManager bm) {
        super(5, new Position(0f, -MainGame.MAX_ROW_Y), bm);
    }

    public void move(float pX) {
        this.position.setX(this.position.getX() + pX * Player.PLAYERSPEED);
        if (Math.abs(this.position.getX()) > MainGame.MAX_COLUMN_X) {
            this.position.setX(
                this.position.getX() > 0
                    ? -MainGame.MAX_COLUMN_X
                    : MainGame.MAX_COLUMN_X
            );
        }
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
