package com.space.view.game.forme;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Particle extends GraphicalObject {

    private static final Random RNG = new Random();

    public float vx, vy;
    public float life, maxLife;
    private Texture cubeTex;

    public Particle() {
        super(0, 0, 0, 0, 0, 0, 1, 1, 1, 1f);
        this.life = 0f;
        this.maxLife = 1f;
        setAlpha(0f);
        try {
            cubeTex = TextureIO.newTexture(new File("assets/OIP.jpg"), true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isAlive() {
        return life > 0f;
    }

    public void respawn(float ex, float ey, float ez) {
        this.setPosition(ex, ey);

        vx = (RNG.nextFloat() - 0.5f) * 500.0f;
        vy = (RNG.nextFloat() - 0.5f) * 500.0f;

        maxLife = 0.8f + RNG.nextFloat() * 1.2f;
        life = maxLife;

        setScale(0.3f + RNG.nextFloat() * 0.06f);
        setColor(1f, 0.8f + 0.2f * RNG.nextFloat(), 0.2f); // spark-ish
        setAlpha(1f);
    }

    public void update(float dt) {
        if (!isAlive()) return;

        translate(vx * dt, vy * dt);

        life -= 200f * dt;
        float t = life / maxLife; // 1 -> 0
        setAlpha(Math.max(0f, Math.min(1f, t)) * 0.5f);
    }

    @Override
    public void displayNormalized(GL2 gl) {
        gl.glTexEnvi(
            GL2.GL_TEXTURE_ENV,
            GL2.GL_TEXTURE_ENV_MODE,
            GL2.GL_MODULATE
        ); // texture * color
        cubeTex.enable(gl);
        cubeTex.bind(gl);
        //gl.glDepthMask(true); // huge difference for lots of blended sprites
        //gl.glColor4f(1.0f, 1.0f, 1.0f, this.a);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0f, 1f);
        gl.glVertex3f(-1f, 1f, 0f);
        gl.glTexCoord2f(1f, 1f);
        gl.glVertex3f(1f, 1f, 0f);
        gl.glTexCoord2f(1f, 0f);
        gl.glVertex3f(1f, -1f, 0f);
        gl.glTexCoord2f(0f, 0f);
        gl.glVertex3f(-1f, -1f, 0f);
        gl.glEnd();
    }
}
