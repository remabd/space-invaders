package com.space.view.game.forme;

import com.jogamp.opengl.GL2;

public class Rect extends GraphicalObject {

    public Rect(
        float x,
        float y,
        float z,
        float aX,
        float aY,
        float aZ,
        float r,
        float g,
        float b,
        float s
    ) {
        super(x, y, z, aX, aY, aZ, r, g, b, s);
    }

    public void displayNormalized(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f, 0f);
        gl.glVertex3f(-1f, -0.1f, 0f);
        gl.glTexCoord2f(1f, 0f);
        gl.glVertex3f(1f, -0.1f, 0f);
        gl.glTexCoord2f(1f, 1f);
        gl.glVertex3f(1f, 0.1f, 0f);
        gl.glTexCoord2f(0f, 1f);
        gl.glVertex3f(-1f, 0.1f, 0f);
        gl.glEnd();
    }
}
