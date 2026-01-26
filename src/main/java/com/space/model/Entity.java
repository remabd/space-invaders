package com.space.model;

import com.space.controller.GameManager;
import com.space.view.game.render.Render;

public abstract class Entity {

    protected Position position;
    protected int hp;
    protected Render render;
    protected GameManager gameManager;

    public Entity(int hp, Position p, GameManager bm) {
        this.position = p;
        this.hp = hp;
        this.gameManager = bm;
    }

    public Position getPosition() {
        return this.position;
    }

    public Render getRender() {
        return this.render;
    }

    abstract void move(float pX, float pY);

    abstract void initRenderer();
}
