package com.space.menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {
  public MainMenu() {
  }

  public void init() {
    JFrame menu = new JFrame("Menu");
    menu.setSize(300, 150);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setVisible(true);

    JLabel titre = new JLabel("SPACE INVADERS");
    JPanel mainPanel = new JPanel();
    JButton startButton = new JButton("Start Game");
    mainPanel.add(startButton);
  }
}
