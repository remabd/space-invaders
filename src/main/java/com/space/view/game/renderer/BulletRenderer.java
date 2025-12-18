package com.space.view.game.renderer;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.space.view.game.forme.Cube;
import com.space.view.game.forme.GraphicalObject;

public class BulletRenderer extends GraphicalObject {
  private ArrayList<GraphicalObject> formes;
  private float vX, vY;

  public BulletRenderer(float x, float y, float z, float aX, float aY, float aZ, float r, float g, float b,
      float scale) {
    super(x, y, z, aX, aY, aZ, r, g, b, scale);
    this.formes = new ArrayList<GraphicalObject>();
    this.formes.add(new Cube("assets/arrow.png", 0f, 0f, 0f, 0f, 0f, 0f, 1f, 1f, 1f, 1f));
  }

  public void displayNormalized(GL2 gl) {
    this.formes.stream().forEach(f -> f.display(gl));
  }

  public void update(float dt) {
    this.move(vX * dt, vY * dt);
  }
}
