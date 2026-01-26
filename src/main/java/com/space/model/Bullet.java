package com.space.model;

import com.space.controller.BulletManager;
import com.space.view.game.MainGame;
import com.space.view.game.render.BulletRender;

public class Bullet extends Entity {

    public static float BULLETSPEED = 2f;

    public static enum BULLET_SOURCE {
        PLAYER,
        MONSTER,
    }

    private BULLET_SOURCE source;

    public Bullet(Position p, BulletManager bm, BULLET_SOURCE source) {
        super(1, p, bm);
        this.source = source;
    }

    @Override
    void resolveDeath() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'resolveDeath'"
        );
    }

    @Override
    public void move(float pX, float pY) {
        if (this.source == Bullet.BULLET_SOURCE.PLAYER) {
            this.position.move(
                new Position(
                    this.position.getX(),
                    this.position.getY() + Bullet.BULLETSPEED
                )
            );
        } else {
            this.position.move(
                new Position(
                    this.position.getX(),
                    this.position.getY() - Bullet.BULLETSPEED
                )
            );
        }
        this.render.setPosition(this.position.getX(), this.position.getY());
    }

    @Override
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
}
