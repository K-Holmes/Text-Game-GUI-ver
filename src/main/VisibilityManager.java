package main;

public class VisibilityManager {

    UI ui = new UI();

    public VisibilityManager(UI userInterface) {

        ui = userInterface;
    }

    // Makes title screen visible
    public void showTitleScreen() {

        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    // Makes game screen visible
    public void titleToGame() {

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
