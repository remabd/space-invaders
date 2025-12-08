package com.space.view.game.forme;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class Cube extends GraphicalObject {
  private ArrayList<Carre> faces;

  public Cube(String texPath, float x, float y, float z, float aX, float aY, float aZ, float r, float g, float b,
      float scale) {
    super(x, y, z, aX, aY, aZ, r, g, b, scale);
    faces = new ArrayList<Carre>();
    faces.add(new Carre("assets/arrow.png", 0f, 0f, 1f, 0f, 0f, 0f, 1f, 0f, 0f, 1f));
    faces.add(new Carre("assets/arrow.png", 0f, 0f, -1f, 0f, 0f, 0f, 1f, 0f, 0f, 1f));
    faces.add(new Carre("assets/arrow.png", 1f, 0f, 0f, 0f, 90f, 0f, 1f, 0f, 0f, 1f));
    faces.add(new Carre("assets/arrow.png", -1f, 0f, 0f, 0f, 90f, 0f, 1f, 0f, 0f, 1f));
    faces.add(new Carre("assets/arrow.png", 0f, 1f, 1f, 90f, 0f, 0f, 1f, 0f, 0f, 1f));
    faces.add(new Carre("assets/arrow.png", 0f, -1f, 1f, 90f, 0f, 0f, 1f, 0f, 0f, 1f));
  }

  public void displayNormalized(GL2 gl) {
    this.faces.stream().forEach(f -> f.display(gl));
  }
}
