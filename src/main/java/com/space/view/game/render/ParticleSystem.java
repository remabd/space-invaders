package com.space.view.game.render;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.space.model.Player;
import com.space.model.Position;
import com.space.view.game.forme.Particle;
import java.util.ArrayList;

public class ParticleSystem {

    private final ArrayList<Particle> particles = new ArrayList<>();
    private float emitterX, emitterY, emitterZ;

    public float emissionRate = 200f; // particles/sec
    public float gravityY = -4.0f;
    public float windX = 10.0f,
        windZ = 0.0f;
    public float drag = 0.3f;

    private float emitAcc = 0f;
    private Texture texture;

    public ParticleSystem(int maxParticles, float x, float y) {
        for (int i = 0; i < maxParticles; i++) particles.add(new Particle());
        this.setEmitter(x, y, - Position.DEPTH);
    }

    public void setEmitter(float x, float y, float z) {
        emitterX = x;
        emitterY = y;
        emitterZ = z;
    }

    public void setTexture(Texture t) {
        texture = t;
    }

    public void update(float dt) {
        emitAcc += emissionRate * dt;
        int toEmit = (int) emitAcc;
        emitAcc -= toEmit;

        for (Particle p : particles) {
            if (toEmit <= 0) break;
            if (!p.isAlive()) {
                p.respawn(emitterX, emitterY, emitterZ);
                toEmit--;
            }
        }

        for (Particle p : particles) {
            p.update(dt, windX, gravityY, windZ, drag);
            // if (p.isAlive() && p.getY() < -3f) p.life = 0f; // cheap “kill plane”
        }
    }

    public void display(GL2 gl) {
        if (texture != null) {
            texture.enable(gl);
            texture.bind(gl);
            gl.glTexEnvi(
                GL2.GL_TEXTURE_ENV,
                GL2.GL_TEXTURE_ENV_MODE,
                GL2.GL_MODULATE
            );
        }

        for (Particle p : particles) if (p.isAlive()) p.display(gl);

        if (texture != null) texture.disable(gl);
    }
}
