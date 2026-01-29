package com.space.view.game.forme;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;

public class Plate extends GraphicalObject {

    private ArrayList<GraphicalObject> faces;

    public Plate(
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
        faces = new ArrayList<GraphicalObject>();
        faces.add(new Carre(0f, 0f, 0.1f, 0f, 0f, 0f, r, g, b, 1f));
        faces.add(new Carre(0f, 0f, -0.1f, 0f, 0f, 0f, r, g, b, 1f));
        faces.add(new Rect(1f, 0f, 0f, 90f, 90f, 0f, r, g, b, 1f));
        faces.add(new Rect(-1f, 0f, 0f, 90f, 90f, 0f, r, g, b, 1f));
        faces.add(new Rect(0f, 1f, 0f, 90f, 0f, 0f, r, g, b, 1f));
        faces.add(new Rect(0f, -1f, 0f, 90f, 0f, 0f, r, g, b, 1f));
    }

    public void displayNormalized(GL2 gl) {
        this.faces.stream().forEach(f -> f.display(gl));
    }
}
