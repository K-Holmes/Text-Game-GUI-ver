import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    Barbarian barb = new Barbarian();
    //Bard bard = new Bard();
    //Knight knight = new Knight();
    //Mage mage = new Mage();
    //Paladin pal = new Paladin();
    //Rogue rogue = new Rogue();

    Color c = new Color(247, 223, 175);
    Color b = new Color(249, 231, 195);
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Papyrus", Font.PLAIN, 90);
    Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    JButton startButton, mageButton, knightButton, rogueButton, bardButton, barbarianButton, paladinButton,
    choice1, choice2, choice3;
    JTextArea maintextArea;
    int playerHP;
    String weapon, position;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler ch = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(c);
        window.setLayout(null);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(b);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(b);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.gray);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.blue);
        con.add(mainTextPanel);

        //need to find a better way to do wrapping, may end up hurting
        //me in future if i don't solve issue
        // also doing \n works just fine in mainTextArea
        maintextArea = new JTextArea("xxx?");
        maintextArea.setBounds(100, 100, 600, 250);
        maintextArea.setBackground(Color.black);
        maintextArea.setForeground(Color.white);
        maintextArea.setFont(normalFont);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        mainTextPanel.add(maintextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 200);
        choiceButtonPanel.setBackground(Color.green);
        choiceButtonPanel.setLayout(new GridLayout(6, 1));
        con.add(choiceButtonPanel);

        barbarianButton = choiceButton("Barbarian");
        bardButton = choiceButton("Bard");
        knightButton = choiceButton("Knight");
        mageButton = choiceButton("Mage");
        paladinButton = choiceButton("Paladin");
        rogueButton = choiceButton("Rogue");
        choice1 = choiceButton("");
        choice2 = choiceButton("");
        choice3 = choiceButton("");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(b);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.darkGray);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.darkGray);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.darkGray);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.darkGray);
        playerPanel.add(weaponLabelName);

        playerSetUp();

    }

    public void playerSetUp(){
        playerHP = 15;
        weapon = "knife";
        hpLabelNumber.setText(""+playerHP);
        weaponLabelName.setText(weapon);
        routeSelection();
    }

    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (position){
                case "start":
                    switch(yourChoice){
                        case "barbarian":
                            //barb.start();
                    }
            }
        }
    }

    //button creator template because im lazy
    public JButton choiceButton(String text) {
        JButton button;
        button = new JButton();
        button.setBackground(Color.red);
        button.setForeground(Color.BLUE);
        button.setFont(normalFont);
        button.setText(text);
        button.setFocusPainted(false);
        button.addActionListener(ch);
        return button;

    }

    public void routeSelection(){
        position = "start";
        maintextArea.setText("Greetings, Traveler. It is time to start your adventure"+
                ". Which class would you like to pursue?");
        choiceButtonPanel.add(barbarianButton);
        barbarianButton.setActionCommand("barbarian");
        choiceButtonPanel.add(bardButton);
        barbarianButton.setActionCommand("bard");
        choiceButtonPanel.add(knightButton);
        barbarianButton.setActionCommand("knight");
        choiceButtonPanel.add(mageButton);
        barbarianButton.setActionCommand("mage");
        choiceButtonPanel.add(paladinButton);
        barbarianButton.setActionCommand("paladin");
        choiceButtonPanel.add(rogueButton);
        barbarianButton.setActionCommand("rogue");
    }
}

class Barbarian extends Game{
    public void start(){
        choiceButtonPanel.setLayout(new GridLayout(1, 2));
        choice1.setText("Choice 1");
        choice2.setText("Choice 1");
        maintextArea.setText("Welcome to the Barbarian class!");
    }

}
