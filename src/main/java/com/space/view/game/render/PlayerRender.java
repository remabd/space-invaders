package com.space.view.game.render;

import com.jogamp.opengl.GL2;
import com.space.model.Render;
import com.space.view.game.forme.Cube;
import com.space.view.game.forme.GraphicalObject;
import java.util.ArrayList;

public class PlayerRender extends GraphicalObject implements Render {

    private ArrayList<GraphicalObject> formes;

    public PlayerRender(
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
        this.formes.add(
            new Cube("assets/arrow.png", 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f)
        );
    }

    public void displayNormalized(GL2 gl) {
        formes.stream().forEach(f -> f.display(gl));
    }
}
