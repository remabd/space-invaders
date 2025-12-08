package com.space.view.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {

  public static void main(String[] args) {
    JFrame menu = new JFrame("Menu");
    menu.setSize(600, 800);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel titre = new JLabel("SPACE INVADERS");
    JPanel mainPanel = new JPanel();
    JButton startButton = new JButton("Start Game");
    mainPanel.setLayout(new FlowLayout());
    mainPanel.add(titre);
    mainPanel.add(startButton);

    CommandPanel commandPanel = new CommandPanel();
    mainPanel.add(commandPanel);

    menu.add(mainPanel);

    menu.setVisible(true);
  }
}
