package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.render.MonsterRender;

public class Monster extends Entity {

    public static float MONSTERSPEED = 1f;

    public Monster(Position p, GameManager bm) {
        super(1, p, bm);
    }

    public void move() {}

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
