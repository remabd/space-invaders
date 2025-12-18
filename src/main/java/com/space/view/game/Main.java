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
import com.space.view.game.renderer.BulletRenderer;
import com.space.view.game.renderer.MonsterRenderer;
import com.space.view.game.renderer.PlayerRenderer;

public class Main extends GLCanvas implements GLEventListener {
  private PlayerRenderer player;
  private ArrayList<MonsterRenderer> monsters;
  private ArrayList<BulletRenderer> friendlyBullets;
  private ArrayList<BulletRenderer> ennemyBullets;
  private float angle;

  public Main() {
    this.addGLEventListener(this);
    PlayerRenderer player = null;
    ArrayList<MonsterRenderer> monsters = new ArrayList<MonsterRenderer>();
    ArrayList<BulletRenderer> friendlyBullets = new ArrayList<BulletRenderer>();
    ArrayList<BulletRenderer> ennemyBullets = new ArrayList<BulletRenderer>();
    this.angle = 0f;
  }

  @Override
  public void init(GLAutoDrawable drawable) {
    BulletRenderer bullet1 = new BulletRenderer(0, 0, 0, 0, 0, 0, 1f, 0, 0, 0.5f);
    friendlyBullets.add(bullet1);
    this.player = new PlayerRenderer(0f, -27f, 0f, 0f, 0f, 0f, 0f, 1f,
        0f, 1f);

    for (int i = 0; i < 27; i++) {
      int[] postion = { -12 + (3 * i) % 27, +27 - (3 * i) / 27 };
      monsters.add(new MonsterRenderer((float) postion[0], (float) postion[1], 0f, 0f, 0f, 0f, 1f,
          0f, 0f, 1f));
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

    for (MonsterRenderer monster : this.monsters) {
      monster.setAngle(this.angle, this.angle, 0f);
      monster.display(gl);
    }
    for (BulletRenderer fBullet : friendlyBullets) {
      fBullet.setAngle(this.angle, this.angle, 0f);
      fBullet.display(gl);
    }
    for (BulletRenderer eBullet : ennemyBullets) {
      eBullet.setAngle(this.angle, this.angle, 0f);
      eBullet.display(gl);
    }
    player.setAngle(this.angle, this.angle, 0f);
    player.display(gl);

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

  private void detectCollisions() {
  }

}
