package com.space.model;

public class Player {
  private float speed;
  private int hp;
  private Position position;

  public Player(int hp) {
    this.hp = hp;
  }

  public boolean isAlive() {
    return this.hp > 0;
  }

  public void takeHit() {
    this.hp--;
  }

  public void moveLeft() {
  }

  public void moveRight() {
  }
}
