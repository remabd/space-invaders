package com.space.view.game.render;

import com.jogamp.opengl.GL2;

public interface Render {
    public void displayNormalized(GL2 gl);

    public void display(GL2 gl);
}
