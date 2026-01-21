package com.space.model;

public class Speed {

    private float vX, vY, vZ;

    public Speed(float vX, float vY, float vZ) {
        this.vX = vX;
        this.vY = vY;
        this.vZ = vZ;
    }

    public void setSpeed(Speed s) {
        this.vX = s.vX;
        this.vY = s.vY;
        this.vZ = s.vZ;
    }

    public Speed getSpeed() {
        return new Speed(this.vX, this.vY, this.vZ);
    }
}
