public class VisibilityManager {
    UI ui;
    public VisibilityManager(){
        ui = userInterface;
    }

    public void showTitleScreen(){
        ui.titleNamePanel.setVisibility(true);
        ui.startButtonPanel.setVisibility(true);

        ui.mainTextPanel.setVisibility(false);
        ui.choiceButtonPanel.setVisibility(false);
        ui.playerPanel.setVisibility(false);
    }

    public void startAdventure(){
        ui.titleNamePanel.setVisibility(false);
        ui.startButtonPanel.setVisibility(false);

        ui.mainTextPanel.setVisibility(true);
        ui.choiceButtonPanel.setVisibility(true);
        ui.playerPanel.setVisibility(true);
    }
}
