package com.space.controller;

import com.space.controller.keys.Key;
import com.space.controller.keys.LeftKey;
import com.space.controller.keys.RightKey;
import com.space.controller.keys.SpaceKey;
import com.space.model.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

//TODO Il faut passer le shoot en KeyTyped et non en Keypressed
public class KeyboardListener implements KeyListener {

    private Player player;
    private HashMap<Integer, Key> keyBinds;

    public KeyboardListener(Player player) {
        this.player = player;
        this.keyBinds = new HashMap<>();
        this.keyBinds.put(KeyEvent.VK_LEFT, new LeftKey(this.player));
        this.keyBinds.put(KeyEvent.VK_RIGHT, new RightKey(this.player));
        this.keyBinds.put(KeyEvent.VK_SPACE, new SpaceKey(this.player));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Key keyPressed = keyBinds.get(e.getKeyCode());
        if (keyPressed != null) {
            keyPressed.doAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
