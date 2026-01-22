package com.space.model;

import com.space.controller.BulletManager;
import com.space.view.game.MainGame;

public class Bullet extends Entity {

    public static float BULLETSPEED = 2f;

    public Bullet(Position p, Speed s, BulletManager bm) {
        super(1, p, s, bm);
    }

    @Override
    void resolveDeath() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'resolveDeath'"
        );
    }

    @Override
    void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    void shoot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shoot'");
    }

    @Override
    void initRenderer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'initRenderer'"
        );
    }
}
