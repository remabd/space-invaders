package com.space.model;

public abstract class Entity {

    protected Position position;
    protected Speed speed;
    protected int hp;
    protected Render render;

    public Entity(int hp, Position p, Speed s) {
        this.position = p;
        this.speed = s;
        this.hp = hp;
        this.initRenderer();
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

    public Speed getSpeed() {
        return this.speed;
    }

    abstract void resolveDeath();

    abstract void move();

    abstract void shoot();

    abstract void initRenderer();
}
