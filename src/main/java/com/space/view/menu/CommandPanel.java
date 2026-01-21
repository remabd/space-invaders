package com.space.view.menu;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommandPanel extends JPanel {

  public CommandPanel() {
    this.init();
  }

  private void init() {
    try {
      this.setLayout(new GridLayout(0, 2));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(10, 10, 10, 10);

      BufferedImage rightArrowPic = ImageIO.read(new File("assets/arrow.png"));
      JLabel rightArrowLabel = new JLabel(new ImageIcon(rightArrowPic));

      BufferedImage leftArrowPic = rightArrowPic;
      JLabel leftArrowLabel = new JLabel(new ImageIcon(leftArrowPic));

      BufferedImage spaceBarPic = ImageIO.read(new File("assets/spacebar.jpg"));
      JLabel spaceBarLabel = new JLabel(new ImageIcon(spaceBarPic));

      JLabel rightAction = new JLabel("Droite");
      JLabel leftAction = new JLabel("Gauche");
      JLabel shootAction = new JLabel("Tirer");

      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.WEST;
      this.add(leftArrowLabel, gbc);

      gbc.gridx = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(leftAction, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.WEST;
      this.add(rightArrowLabel, gbc);

      gbc.gridx = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(rightAction, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.anchor = GridBagConstraints.WEST;
      this.add(spaceBarLabel, gbc);

      gbc.gridx = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(shootAction);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
