package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    BackgroundMusic bgm = new BackgroundMusic();

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPosition1, nextPosition2;

    public Game() {
        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
        bgm.sound();
    }

    public static void main(String[] args) { new Game(); }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String choice = event.getActionCommand();

            switch (choice) {
                case "start" -> {
                    vm.titleToGame();
                    story.clericApproach();
                }
                case "c1" -> story.selectPosition(nextPosition1);
                case "c2" -> story.selectPosition(nextPosition2);
            }
        }
    }
}