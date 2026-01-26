package com.space.controller;

import com.space.model.Bullet;

public interface GameManager {
    void addBullet(Bullet bullet);
    void gameOver();
    void win();
}
