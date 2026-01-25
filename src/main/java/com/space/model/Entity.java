package com.space.model;

import com.space.controller.BulletManager;
import com.space.view.game.render.Render;

public abstract class Entity {

    protected Position position;
    protected int hp;
    protected Render render;
    protected BulletManager bulletController;

    public Entity(int hp, Position p, BulletManager bm) {
        this.position = p;
        this.hp = hp;
        this.bulletController = bm;
    }

    public void loseHp() {
        this.hp--;
        if (this.hp == 0) {
            this.resolveDeath();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Render getRender() {
        return this.render;
    }

    abstract void resolveDeath();

    abstract void move(float pX, float pY);

    abstract void shoot();

    abstract void initRenderer();
}
