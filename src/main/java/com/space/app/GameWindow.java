package com.space.app;

import java.awt.Dimension;

import javax.swing.JFrame;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;

public class GameWindow extends GLCanvas implements GLEventListener {
  public static void main() {
    GLCanvas canvas = new GameWindow();
    canvas.setPreferredSize(new Dimension(600, 800));
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(canvas);
    frame.setTitle("Java - OpenGL");
    frame.pack();
    frame.setVisible(true);
    final Animator animator = new Animator(canvas);
    animator.start();
  }

  @Override
  public void display(GLAutoDrawable arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'display'");
  }

  @Override
  public void dispose(GLAutoDrawable arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dispose'");
  }

  @Override
  public void init(GLAutoDrawable arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'init'");
  }

  @Override
  public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'reshape'");
  }
  // Comment
}
