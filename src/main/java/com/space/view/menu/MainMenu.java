package com.space.view.menu;

import com.jogamp.opengl.util.FPSAnimator;
import com.space.view.game.MainGame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {

    public static void main(String[] args) {
        JFrame menu = new JFrame("Menu");
        menu.setSize(600, 800);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JLabel titre = new JLabel("SPACE INVADERS");
        titre.setFont(new Font("Serif", Font.PLAIN, 30));

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            MainGame gameCanvas = new MainGame();

            menu.getContentPane().removeAll();
            menu.getContentPane().add(gameCanvas, BorderLayout.CENTER);

            menu.revalidate();
            menu.repaint();

            gameCanvas.requestFocusInWindow();

            new FPSAnimator(gameCanvas, 30).start();
        });

        // CommandPanel commandPanel = new CommandPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0;
        gbc.weighty = 1.0;
        mainPanel.add(titre, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0;
        mainPanel.add(startButton, gbc);

        // gbc.gridy = 2;
        // gbc.weighty = 0;
        // mainPanel.add(commandPanel, gbc);

        menu.add(mainPanel);

        menu.setVisible(true);
    }
}
