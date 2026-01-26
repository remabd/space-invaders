package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.render.BulletRender;

public class Bullet extends Entity {

    public static float BULLETSPEED = 2f;

    public static enum BULLET_SOURCE {
        PLAYER,
        MONSTER,
    }

    private BULLET_SOURCE source;

    public Bullet(Position p, GameManager bm, BULLET_SOURCE source) {
        super(1, p, bm);
        this.source = source;
    }

    public void move() {
        if (this.source == Bullet.BULLET_SOURCE.PLAYER) {
            this.position.setPosition(
                new Position(
                    this.position.getX(),
                    this.position.getY() + Bullet.BULLETSPEED
                )
            );
        } else {
            this.position.setPosition(
                new Position(
                    this.position.getX(),
                    this.position.getY() - Bullet.BULLETSPEED
                )
            );
        }
        this.render.setPosition(this.position.getX(), this.position.getY());
    }

    public void initRenderer() {
        this.render = new BulletRender(
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

    public BULLET_SOURCE getSource() {
        return this.source;
    }
}
