package com.space.controller;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.space.model.Player;

public class KeyboardListener implements KeyListener {
    private Player player;

    public KeyboardListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.err.println(e.toString());
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    }
}
