package com.space.view.game.forme;

import com.jogamp.opengl.GL2;

public abstract class GraphicalObject {
  private float x, y, z;
  private float aX, aY, aZ;
  private float r, g, b, a;
  private float scale;

  public GraphicalObject(float x, float y, float z, float aX, float aY, float aZ, float r, float g, float b,
      float scale) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.aX = aX;
    this.aY = aY;
    this.aZ = aZ;
    this.r = r;
    this.g = g;
    this.b = b;
    this.scale = scale;
    this.a = 1f;
  }

  public abstract void displayNormalized(GL2 gl);

  public void setAlpha(float a) {
    this.a = a;
  }

  public void setAngle(float aX, float aY, float aZ) {
    this.aX = aX;
    this.aY = aY;
    this.aZ = aZ;
  }

  public void display(GL2 gl) {
    gl.glPushMatrix();
    gl.glTranslatef(this.x, this.y, this.z);
    gl.glRotatef(this.aX, 1f, 0f, 0f);
    gl.glRotatef(this.aY, 0f, 1f, 0f);
    gl.glRotatef(this.aZ, 0f, 0f, 1f);
    gl.glScalef(this.scale, this.scale, this.scale);
    gl.glColor4f(this.r, this.g, this.b, this.a);
    this.displayNormalized(gl);
    gl.glPopMatrix();
  }

}
