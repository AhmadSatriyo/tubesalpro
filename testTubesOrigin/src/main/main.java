package main;

import script.background;
import script.detektif;
import script.character;
import scene.HomeScreen.homeScreen;
import script.posisi;

public class Main {
    
    
    public static background bgTangga = new background("/assets/background/tangga.jpg", "Latar Tangga");
    public static detektif guwe = new detektif("/assets/character/detektif.jpg", "detektif", "Sensei");
    public static character mutsukiHappy = new character("/assets/character/mustuki_happy.png", "mutsuki");
    public static background homeScreenBackground = new background("/assets/background/homeScreen.png", "lobby screen");
    public static background textBoxBackground = new background("/assets/ui/input.png", "teks box input nama");
    
    public static void main(String[] args) {
        
        new scene.HomeScreen.homeScreen().setVisible(true);
    }
}