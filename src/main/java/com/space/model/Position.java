package com.space.model;

public class Position {

    public static float DEPTH = 70f;
    private float x, y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
