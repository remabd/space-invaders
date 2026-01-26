package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.MainGame;
import com.space.view.game.render.MonsterRender;

public class Monster extends Entity {

    public static float MONSTERSPEED = 0.1f;

    public Monster(Position p, GameManager bm) {
        super(1, p, bm);
    }

    public void move() {
        position.setX(
            (((int) position.getY()) % 2 == 0)
                ? position.getX() - Monster.MONSTERSPEED
                : position.getX() + Monster.MONSTERSPEED
        );
        if (Math.abs(this.position.getX()) > MainGame.MAX_COLUMN_X) {
            this.position.setX(
                this.position.getX() > 0
                    ? this.position.getX() - 1
                    : this.position.getX() + 1
            );
            this.position.setY(
                this.position.getY() - MainGame.SPACE_BETWEEN_ROWS
            );
        }
        this.render.setPosition(this.position.getX(), this.position.getY());
    }

    public void resolveDeath() {}

    public void shoot() {}

    public void initRenderer() {
        this.render = new MonsterRender(
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
