package com.space.view.game.render;

import com.jogamp.opengl.GL2;
import com.space.view.game.forme.GraphicalObject;
import com.space.view.game.forme.Plate;
import java.util.ArrayList;

public class MonsterRender extends GraphicalObject implements Render {

    private ArrayList<GraphicalObject> formes;

    public MonsterRender(
        float x,
        float y,
        float z,
        float aX,
        float aY,
        float aZ,
        float r,
        float g,
        float b,
        float scale
    ) {
        super(x, y, z, aX, aY, aZ, r, g, b, scale);
        this.formes = new ArrayList<GraphicalObject>();
        this.formes.add(new Plate(0f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(0f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(0f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(2f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(2f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(2f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(2f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(2f, -6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(4f, -6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(4f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(4f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(4f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(4f, 6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(6f, -4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(6f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(6f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(6f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(6f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(6f, 8f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(8f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(8f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(10f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(10f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(10f, -4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(-2f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-2f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-2f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-2f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-2f, -6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(-4f, -6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-4f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-4f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-4f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-4f, 6f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(-6f, -4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-6f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-6f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-6f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-6f, 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-6f, 8f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(-8f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-8f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));

        this.formes.add(new Plate(-10f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-10f, -2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
        this.formes.add(new Plate(-510f, -4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f));
    }

    public void displayNormalized(GL2 gl) {
        formes.stream().forEach(f -> f.display(gl));
    }
}
