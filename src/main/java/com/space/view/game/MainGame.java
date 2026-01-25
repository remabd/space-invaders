package com.space.view.game;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.space.controller.BulletManager;
import com.space.controller.KeyboardListener;
import com.space.model.Bullet;
import com.space.model.Monster;
import com.space.model.Player;
import com.space.model.Position;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MainGame
    extends GLCanvas
    implements GLEventListener, BulletManager
{

    private Player player;
    private ArrayList<Monster> monsters;
    private ArrayList<Bullet> bullets;
    private float angle;

    public MainGame() {
        this.addGLEventListener(this);
        this.player = new Player(this);
        this.monsters = new ArrayList<Monster>();
        this.bullets = new ArrayList<Bullet>();
        this.angle = 0f;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // objects.add(player);
        this.player.initRenderer();
        this.initMonsters();
        this.monsters.forEach(m -> m.initRenderer());
        this.addKeyListener(new KeyboardListener(this.player));
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
        // this.angle += 1f;
        gl.glTranslatef(0f, 0f, -Position.DEPTH);
        this.player.getRender().display(gl);
        this.monsters.stream().forEach(m -> m.getRender().display(gl));
        // for (GraphicalObject object : this.objects) {
        //     object.setAngle(this.angle, this.angle, 0f);
        //     object.display(gl);
        // }
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

    @Override
    public void reshape(
        GLAutoDrawable drawable,
        int x,
        int y,
        int width,
        int height
    ) {
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
        GLCanvas canvas = new MainGame();
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

    @Override
    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }

    private void initMonsters() {
        for (int i = 0; i < 27; i++) {
            int[] position = { -12 + ((3 * i) % 27), +27 - (3 * i) / 27 };
            monsters.add(
                new Monster(new Position(position[0], position[1]), this)
            );
        }
    }
}
