package com.space.controller;

import com.space.controller.keys.Key;
import com.space.controller.keys.LeftKey;
import com.space.controller.keys.RightKey;
import com.space.controller.keys.SpaceKey;
import com.space.model.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyboardListener implements KeyListener {

    private Player player;

    public KeyboardListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Map<Integer, Key> keyBinds = new HashMap<>();
        keyBinds.put(KeyEvent.VK_LEFT, new LeftKey(this.player));
        keyBinds.put(KeyEvent.VK_RIGHT, new RightKey(this.player));
        keyBinds.put(KeyEvent.VK_SPACE, new SpaceKey(this.player));

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
