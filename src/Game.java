import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    Color c = new Color(247, 223, 175);
    Color b = new Color(249, 231, 195);
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Papyrus", Font.PLAIN, 90);
    Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    JButton startButton, mageButton, knightButton, rogueButton, bardButton, barbarianButton, paladinButton;
    JTextArea maintextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

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
        //me in future if i dont solve issue
        maintextArea = new JTextArea("Greetings, Traveler. It is time to start your adventure"+
                ". Which class would you like to pursue?");
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

        choiceButtonPanel.add(barbarianButton);
        choiceButtonPanel.add(bardButton);
        choiceButtonPanel.add(knightButton);
        choiceButtonPanel.add(mageButton);
        choiceButtonPanel.add(paladinButton);
        choiceButtonPanel.add(rogueButton);

    }

    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
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
        return button;

    }
}
