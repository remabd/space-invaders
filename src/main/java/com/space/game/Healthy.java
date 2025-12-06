package com.space.game;

public abstract class Healthy {
  int hp, maxHP;

  public Healthy(int hp) {
    this.hp = hp;
    this.maxHP = hp;
  }

  public boolean isAlive() {
    return this.hp > 0;
  }

  public void takeHit() {
    this.hp--;
  }
}
