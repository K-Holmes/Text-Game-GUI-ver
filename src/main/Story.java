package main;

import weapons.Staff;

import java.util.Arrays;

public class Story {
    BackgroundMusic bgm = new BackgroundMusic();

    Game g;
    UI ui;
    VisibilityManager vm;
    Player p = new Player();

    //items necessary to check for potion strength
    boolean weakened = false, strongButWeak = false;
    String[] userPotionItems = new String[4];
    String[] goodPotionItems = {"sun-dried raisins", "lavender oil", "fresh animal blood", "scar-root"};
    String[] greatPotionItems = {"sun-dried raisins", "lavender oil", "fresh animal blood", "ethria sage"};

    public Story(Game game, UI userInterFace, VisibilityManager visibilityManager) {

        g = game;
        ui = userInterFace;
        vm = visibilityManager;
    }

    public void defaultSetup() {

        p.title = "Mage";
        ui.playerTitleNameLabel.setText("" + p.title);

        p.weaponOfChoice = new Staff();
        ui.weaponNameLabel.setText(p.weaponOfChoice.name);
    }
    public void selectPosition(String nextPosition) {

        switch (nextPosition) {
            case "leave" -> vm.showTitleScreen();
            case "restart" -> clericApproach();
            case "yes" -> yes();
            case "no" -> no();
            case "goToGarden" -> gatherIngredients1();
            case "petals" -> gatherIngredients2_1();
            case "raisins" -> gatherIngredients2_2();
            case "lavender" -> lavender();
            case "demonia" -> demonia();
            case "findLifeSource" -> gatherIngredients3();
            case "blood" -> blood();
            case "tissue" -> tissue();
            case "walkToCave" -> caveEncounter();
            case "hasAllIngredients" -> outsideOrInside();
            case "swing" -> swingStaff();
            case "spell" -> castSpell();
            case "investigate" -> investigate();
            case "ignore" -> ignore();
            case "outside" -> inTheOpen();
            case "apothecary" -> inTheApothecary();
            case "weakened" -> weakPotion();
            case "strong" -> strongPotion();
            case "savedDeadFlower" -> savedDeadFlower();
            case "createdStrongFlower" -> createdStrongFlower();
            case "savior" -> saviorEnding();
            case "potionsMaster" -> potionsMasterEnding();
            case "youDied" -> deadEnding();
            case "boring" -> boringEnding();
            //new routes below
            case "wrong" -> wrongIngredients();
            case "soClose" -> soCloseEnding();
            case "superStrong" -> superStrongPotion();
            case "apprenticeEnding" -> apprenticeEnding();
            case "strongWeakened" -> strongWeakened();
            case "almostThereEnding" -> almostThereEnding();
            case "strongButNotEnding" -> strongButNotEnding();
            case "createdSuperStrongFlower" -> createdSuperStrongFlower();
        }
    }

    public void clericApproach() {
        //done for those who restart to reset title
        strongButWeak = false;
        p.title = "Mage";
        ui.playerTitleNameLabel.setText("" + p.title);

        ui.mainTextArea.setText("" +
                "You start off the adventure with some basic spell knowledge and a magic staff. " +
                "You're walking around the marketplace and a cleric approaches you. " +
                "He requests some assistance in potion making, as his apprentice has messed up. " +
                "Would you like to accept?" +
                "");
        ui.choice1.setText("Yes");
        ui.choice2.setText("No");

        g.nextPosition1 = "yes";
        g.nextPosition2 = "no";
    }
    public void yes() {
        bgm.paperRustle();
        ui.mainTextArea.setText("" +
                "With a smile, the cleric hands you an address and a list of ingredients needed and you set off " +
                "to the Ether garden. You need a binding agent, fragrance, a source of life, and " +
                "plant base. " +
                "");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "goToGarden";
        g.nextPosition2 = "";
    }
    public void no() {
        bgm.badChoice();
        ui.mainTextArea.setText("" +
                "The cleric understands and leaves you to whatever you were doing." +
                "");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "boring";
        g.nextPosition2 = "";
    }
    public void boringEnding() {
        ui.mainTextArea.setText("" +
                "[BORING MAGE ENDING]" +
                "");

        p.title = "BORING";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }

    public void gatherIngredients1() {
        ui.mainTextArea.setText("" +
                "You enter the lush garden and locate a clearing, in it are some rose petals " +
                "and raisins that have been dried by the sun. " +
                "Which would be the better binding agent? " +
                "");
        ui.choice1.setText("Petals");
        ui.choice2.setText("Raisins");

        g.nextPosition1 = "petals";
        g.nextPosition2 = "raisins";
    }
    public void gatherIngredients2_1() {
        bgm.walk();
        userPotionItems[0] = "petals";
        ui.mainTextArea.setText("" +
                "You pocket the petals and move onto a flower field. You find lavender, which can be " +
                "pressed for its oil, and demonia, which can be smoked.\nWhat will the fragrance be?" +
                "");
        ui.choice1.setText("Lavender");
        ui.choice2.setText("Demonia");

        g.nextPosition1 = "lavender";
        g.nextPosition2 = "demonia";
    }
    public void gatherIngredients2_2() {
        bgm.walk();
        userPotionItems[0]= "sun-dried raisins";
        ui.mainTextArea.setText("" +
                "You pocket the raisins and move onto a flower field. You find lavender, which can be " +
                "pressed for its oil, and demonia, which can be smoked.\nWhat will the fragrance be?" +
                "");
        ui.choice1.setText("Lavender");
        ui.choice2.setText("Demonia");

        g.nextPosition1 = "lavender";
        g.nextPosition2 = "demonia";
    }
    public void lavender() {
        bgm.mageSounds("snip");
        userPotionItems[1] = "lavender oil";
        ui.mainTextArea.setText("" +
                "You carefully pick a handful of lavender and stick in an oil jar before moving on." +
                "");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "findLifeSource";
        g.nextPosition2 = "";
    }
    public void demonia() {
        bgm.mageSounds("snip");
        userPotionItems[1]= "demonia leaves";
        ui.mainTextArea.setText("" +
                "You bend down and cut the leaves off of a demonia plant before moving on." +
                "");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "findLifeSource";
        g.nextPosition2 = "";
    }
    public void gatherIngredients3() {
        ui.mainTextArea.setText("" +
                "Nearing a mountain edge, you come across a fresh deer corpse. You can collect " +
                "it's blood in a vial or grab some of the tissue.\nWhich will you pick?" +
                "");
        ui.choice1.setText("Blood");
        ui.choice2.setText("Tissue");

        g.nextPosition1 = "blood";
        g.nextPosition2 = "tissue";
    }
    public void blood() {
        bgm.mageSounds("blood");
        userPotionItems[2] = "fresh animal blood";
        ui.mainTextArea.setText("" +
                "You squeeze out some of the trickling blood into a vial and go on your way." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "walkToCave";
        g.nextPosition2 = "";
    }
    public void tissue() {
        bgm.mageSounds("tissue");
        userPotionItems[2] = "dying tissue";
        ui.mainTextArea.setText("" +
                "You slice a chunk of the dying tissue, wrapping it in cloth and continue on your path." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "walkToCave";
        g.nextPosition2 = "";
    }
    public void caveEncounter() {
        bgm.mageSounds("scream");
        ui.mainTextArea.setText("" +
                "As you make your way through the garden for the last ingredient, you pass by a cave. " +
                "You hear some concerning sounds, most likely someone in pain.\nWhat do you do?" +
                "");

        ui.choice1.setText("Investigate");
        ui.choice2.setText("Ignore");

        g.nextPosition1 = "investigate";
        g.nextPosition2 = "ignore";
    }
    public void investigate() {
        bgm.growl();
        ui.mainTextArea.setText("" +
                "You enter the cave, clutching your staff to your chest. Inside an Elf cowers underneath " +
                "a Majoris Bear. You hold out your staff, drawing the bear's attention to you.\n" +
                "Do you swing or cast a spell?" +
                "");

        ui.choice1.setText("Swing");
        ui.choice2.setText("Cast Spell");

        g.nextPosition1 = "swing";
        g.nextPosition2 = "spell";
    }
    public void swingStaff() {
        bgm.died();
        ui.mainTextArea.setText("" +
                "You charge at the bear and swing at the open air, and the bear sends you " +
                "crashing into the cave wall, knocking the air out of you." +
                "\nThe bear enjoys a lovely meal on that day." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "youDied";
        g.nextPosition2 = "";
    }
    public void castSpell() {
        bgm.mageSounds("attack");
        userPotionItems[3] = "ethria sage";
        ui.mainTextArea.setText("" +
                "You raise your magic staff high in the air and cast the strongest spell in your arsenal. " +
                "The bear is sent crashing into adjacent cave wall, and you quickly drag the elf out." +
                "After healing her wounds, she offers you some Ethria sage, a very powerful plant base." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "hasAllIngredients";
        g.nextPosition2 = "";
    }
    public void deadEnding() {
        bgm.badChoice();
        ui.mainTextArea.setText("" +
                "[YOU DIED ENDING]" +
                "");

        p.title = "DEAD";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }
    public void ignore() {
        bgm.walk();
        userPotionItems[3]= "scar-root";
        ui.mainTextArea.setText("" +
                "You pass the cave and find some scar-root stems left over from the harvest. " +
                "You take them and exit the garden." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "hasAllIngredients";
        g.nextPosition2 = "";
    }
    public void outsideOrInside() {
        ui.mainTextArea.setText("" +
                "Now that you have all the ingredients, you need to decide whether to mix " +
                "the potion out in the open with your own tools or find an apothecary." +
                "");

        ui.choice1.setText("Outside");
        ui.choice2.setText("Apothecary");

        g.nextPosition1 = "outside";
        g.nextPosition2 = "apothecary";
    }
    public void inTheOpen() {
        bgm.mageSounds("potion");
        weakened = true;
        ui.mainTextArea.setText("" +
                "You conjure a small fire, crouch down, and begin mixing all the ingredients. " +
                "However, mixing everything outside without proper tools increased the oxidation of the mixture" +
                ", reducing it's strength." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        if (Arrays.equals(userPotionItems, goodPotionItems)){
            g.nextPosition1 = "weakened";
        } else if (Arrays.equals(userPotionItems, greatPotionItems)){
            g.nextPosition1 = "strongWeakened";
        } else {
            g.nextPosition1 = "wrong";
        }

        //g.nextPosition1 = "weakened";
        g.nextPosition2 = "";
    }
    public void inTheApothecary() {
        bgm.mageSounds("potion");
        ui.mainTextArea.setText("" +
                "You run into town and find a nearby apothecary and craft the potion. " +
                "The equipment allows for low oxidization and creates a strong potion." +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        if (Arrays.equals(userPotionItems, goodPotionItems)){
            g.nextPosition1 = "strong";
        } else if (Arrays.equals(userPotionItems, greatPotionItems)){
            g.nextPosition1 = "superStrong";
        } else {
            g.nextPosition1 = "wrong";
        }
        //g.nextPosition1 = "strong";
        g.nextPosition2 = "";
    }
    public void weakPotion() {
        bgm.mageSounds("door");
        ui.mainTextArea.setText("" +
                "You arrive at the address the Cleric gave you, and find him standing in another small " +
                "garden full of dead plants, waiting for you. He nods in acknowledgement as you explain " +
                "how you made the potion. You pour a drop on a nearby dead flower, " +
                "and after some time it begins to revitalize itself!" +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "savedDeadFlower";
        g.nextPosition2 = "";
    }
    public void savedDeadFlower() {
        ui.mainTextArea.setText("" +
                "The cleric is ecstatic, and hands you a pouch full of silver and gold coins." +
                "\nYou've saved the kingdom from famine!" +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        if (strongButWeak) {
            g.nextPosition1 = "almostThereEnding";
        } else {
            g.nextPosition1 = "savior";
        }
        g.nextPosition2 = "";
    }
    public void saviorEnding() {
        ui.mainTextArea.setText("" +
                "[SAVIOR ENDING]" +
                "");

        p.title = "Savior";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }
    public void strongPotion() {
        bgm.mageSounds("door");
        ui.mainTextArea.setText("" +
                "You arrive at the address the Cleric gave you, and find him standing in a small garden, " +
                "waiting for you. He smiles and nods as you explain how you made the potion. " +
                "As you pour a drop on a nearby dead flower, all is still for some time, and then all of the flowers" +
                "in the garden slowly begin to sprout up tall!" +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "createdStrongFlower";
        g.nextPosition2 = "";
    }
    public void createdStrongFlower() {
        ui.mainTextArea.setText("" +
                "The cleric thanks you a thousand times over. You've not only saved the kingdom, " +
                "but show such potential you could possibly solve world hunger!" +
                "\nHe hands you a bag full of coins and a blue Mage Stone" +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "strongButNotEnding";
        g.nextPosition2 = "";
    }
    public void potionsMasterEnding() {
        ui.mainTextArea.setText("" +
                "[POTIONS MASTER ENDING]" +
                "");

        p.title = "PM.";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }

    public void wrongIngredients() {
        ui.mainTextArea.setText("" +
                "You enter the Cleric's rise with a hop in your step, content " +
                "with your potion. He greets you and questions the ingredients. " +
                "Upon hearing them, he sends you away with a sigh. You mixed the " +
                "wrong potion.");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "soClose";
        g.nextPosition2 = "";
    }

    public void soCloseEnding() {
        ui.mainTextArea.setText("" +
                "[SO CLOSE ENDING]" +
                "");

        p.title = "Failure";
        ui.playerTitleNameLabel.setText("" + p.title);

        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }

    public void superStrongPotion() {
        ui.mainTextArea.setText("" +
                "You tell him the ingredients and his eyes sparkle as he smiles. You show great potential" +
                " as an apprentice. He brings you to a row of dead flowers and feed the potion to them." +
                " Within the blink of an eye they all stand up as healthy as the day they bloomed.");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "createdSuperStrongFlower";
        g.nextPosition2 = "";
    }
    public void apprenticeEnding() {
        ui.mainTextArea.setText("" +
                "[APPRENTICE ENDING]" +
                "");

        p.title = "Apprentice";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }

    public void strongWeakened() {
        strongButWeak = true;
        ui.mainTextArea.setText("" +
                "You tell him the ingredients and his eyes sparkle as he smiles. You show great potential" +
                "as an apprentice. He brings you to a row of dead flowers and feed the potion to them." +
                " They bloom slowly but within the minute. It would've been faster had it been stronger.");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "savedDeadFlower";
        g.nextPosition2 = "";
    }
    public void almostThereEnding() {
        ui.mainTextArea.setText("" +
                "[ALMOST THERE ENDING]" +
                "");

        p.title = "Mage";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }
    public void strongButNotEnding() {
        ui.mainTextArea.setText("" +
                "[NEARLY PERFECT ENDING]" +
                "");

        p.title = "Arch Mage";
        ui.playerTitleNameLabel.setText("" + p.title);
        ui.choice1.setText("Restart");
        ui.choice2.setText("Leave");

        g.nextPosition1 = "restart";
        g.nextPosition2 = "leave";
    }
    public void createdSuperStrongFlower() {
        ui.mainTextArea.setText("" +
                "The cleric falls on his knees and weeps. You've not only saved the kingdom, " +
                "but possibly the entire problem of world hunger!" +
                "\nHe hands you a Green Mage Stone, officially making you a Potions Master!" +
                "");

        ui.choice1.setText(">");
        ui.choice2.setText("");

        g.nextPosition1 = "potionsMaster";
        g.nextPosition2 = "";
    }
}
