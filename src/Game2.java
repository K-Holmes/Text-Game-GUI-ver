import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game2 {
    ChoiceHandler ch = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager();
    Story story = new Story(this, ui, vm);

    public static void main(String[] args) {
        new Game2();
    }

    public Game2(){
        ui.createUI(ch);
        story.defaultSetup();
        vm.showTitleScreen();
    }
    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            switch (position){
                case "start":
                    vm.startAdventure();
                    switch(yourChoice){
                        case "barbarian":
                            //barb.start();
                            break;
                    }
            }
        }
    }

}
