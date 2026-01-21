package com.space.view.game.forme;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Carre extends GraphicalObject {
  Texture texture;

  public Carre(String texPath, float x, float y, float z, float aX, float aY, float aZ, float r, float g, float b,
      float scale) {
    super(x, y, z, aX, aY, aZ, r, g, b, scale);

    try {
      this.texture = TextureIO.newTexture(new File(texPath), true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void displayNormalized(GL2 gl) {
    texture.enable(gl);
    texture.bind(gl);
    gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);
    gl.glBegin(GL2.GL_QUADS);
    gl.glTexCoord2f(0f, 0f);
    gl.glVertex3f(-1f, -1f, 0f);
    gl.glTexCoord2f(1f, 0f);
    gl.glVertex3f(1f, -1f, 0f);
    gl.glTexCoord2f(1f, 1f);
    gl.glVertex3f(1f, 1f, 0f);
    gl.glTexCoord2f(0f, 1f);
    gl.glVertex3f(-1f, 1f, 0f);
    gl.glEnd();
  }
}
