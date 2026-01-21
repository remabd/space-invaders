package com.space.model;

public class Player extends Entity {

    public Player() {
        super(5, new Position(0f, -5f), new Speed(0f, 0f, 0f));
    }

    public void move() {}

    public void resolveDeath() {}

    public void shoot() {}
}
