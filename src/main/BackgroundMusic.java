package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class BackgroundMusic {
    //sounds used by more than one route here
    public void sound() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/pigwhistle.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            FloatControl gainControl =
                    (FloatControl) test.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f);
            test.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void goodChoice(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/good_choice.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void badChoice(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/bad_choice.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            FloatControl gainControl =
                    (FloatControl) test.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void growl(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/bearGrowl.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void died(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/dying.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paperRustle(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/paper.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void walk(){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/walking.wav"));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mageSounds(String sound){
        try {
            Clip test;
            AudioInputStream ais;
            switch (sound){
                case "attack":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/mageAtk.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "blood":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/bloodCollect.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "potion":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/mixPotion.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "door":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/doorCreak.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "snip":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/snip.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "tissue":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/tissue.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
                case "scream":
                    ais = AudioSystem.getAudioInputStream(new File("src/main/sounds/MageSounds/caveScream.wav"));
                    test = AudioSystem.getClip();
                    test.open(ais);
                    test.start();
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
