package main;

import javax.swing.*;
import java.awt.*;

public class UI {

    // COLORS
    Color a = new Color(126, 214, 230);

    // FONTS
    Font titleFont = new Font("Papyrus", Font.PLAIN, 60);
    Font normalFont = new Font("Papyrus", Font.PLAIN, 26);

    // WINDOW VARIABLES
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, playerTitleLabel, playerTitleNameLabel, weaponLabel, weaponNameLabel;
    JButton startButton, choice1, choice2;
    JTextArea mainTextArea;

    public void createUI(Game.ChoiceHandler cHandler) {

        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(a);
        window.setLayout(null);

        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(a);
        titleNameLabel = new JLabel("MAGE QUEST");
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // START BUTTON
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(a);
        startButton = new JButton("START");
        startButton.setBackground(a);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        // ADD TITLE & START BUTTON
        window.add(titleNamePanel);
        window.add(startButtonPanel);

        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(a);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(a);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(a);
        choiceButtonPanel.setLayout(new GridLayout(3, 3));
        window.add(choiceButtonPanel);

        choice1 = new JButton("");
        choice1.setBackground(a);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("");
        choice2.setBackground(a);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(a);
        playerPanel.setLayout(new GridLayout(1, 3));
        window.add(playerPanel);

        playerTitleLabel = new JLabel("Title:");
        playerTitleLabel.setFont(normalFont);
        playerTitleLabel.setForeground(Color.black);
        playerPanel.add(playerTitleLabel);

        playerTitleNameLabel = new JLabel();
        playerTitleNameLabel.setFont(normalFont);
        playerTitleNameLabel.setForeground(Color.black);
        playerPanel.add(playerTitleNameLabel);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.black);
        playerPanel.add(weaponLabel);

        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(normalFont);
        weaponNameLabel.setForeground(Color.black);
        playerPanel.add(weaponNameLabel);

        // MAKE WINDOW VISIBLE
        window.setVisible(true);
    }
}
