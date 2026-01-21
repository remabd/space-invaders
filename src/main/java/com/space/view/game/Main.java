package com.space.view.game;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.space.view.game.forme.Cube;
import com.space.view.game.forme.GraphicalObject;
import com.space.view.game.renderer.MonsterRenderer;
import com.space.view.game.renderer.PlayerRenderer;

public class Main extends GLCanvas implements GLEventListener {
  private ArrayList<GraphicalObject> objects;
  private float angle;

  public Main() {
    this.addGLEventListener(this);
    this.objects = new ArrayList<GraphicalObject>();
    this.angle = 0f;
  }

  @Override
  public void init(GLAutoDrawable drawable) {
    Cube c1 = new Cube("assets/arrow.png", 0, 0, 0, 0, 0, 0, 1f, 0, 0, 2f);
    objects.add(c1);
    PlayerRenderer player = new PlayerRenderer(0f, -27f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 1f);
    objects.add(player);
    for (int i = 0; i < 27; i++) {
      int[] position = { -12 + (3 * i) % 27, +27 - (3 * i) / 27 };
      objects.add(new MonsterRenderer((float) position[0], (float) position[1], 0f, 0f, 0f, 0f, 1f, 0f, 0f, 1f));
    }

    this.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(KeyEvent arg0) {
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
      }

      @Override
      public void keyReleased(KeyEvent arg0) {
        // throw new UnsupportedOperationException("Unimplemented method
        // 'keyReleased'");
      }

      @Override
      public void keyTyped(KeyEvent arg0) {
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
      }

    });
    GL2 gl = drawable.getGL().getGL2();
    gl.glEnable(GL2.GL_TEXTURE_2D);
    gl.glEnable(GL2.GL_BLEND);
    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);
    gl.glDepthFunc(GL2.GL_ALWAYS);
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    gl.glHint(GL2.GL_POINT_SMOOTH_HINT, GL2.GL_NICEST);
  }

  @Override
  public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    this.angle += 1f;
    gl.glTranslatef(0f, 0f, -70f);
    for (GraphicalObject object : this.objects) {
      object.setAngle(this.angle, this.angle, 0f);
      object.display(gl);
    }
  }

  @Override
  public void dispose(GLAutoDrawable arg0) {
    // throw new UnsupportedOperationException("Unimplemented method 'dispose'");
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    GL2 gl = drawable.getGL().getGL2();
    final GLU glu = new GLU();
    float aspect = (float) width / height;
    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluPerspective(45f, aspect, .1f, 100f);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glEnable(GL2.GL_DEPTH_TEST);
  }

  public static void main(String[] args) {
    GLCanvas canvas = new Main();
    canvas.setPreferredSize(new Dimension(600, 800));
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(canvas);
    frame.setTitle("Space Invaders");
    frame.pack();
    frame.setVisible(true);
    final Animator animator = new Animator(canvas);
    animator.start();
  }
}
