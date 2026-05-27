package main;

import script.background;
import script.detektif;
import script.character;

public class Main {
    
    
    public static background bgTangga = new background("/assets/background/tangga.jpg", "Latar Tangga");
    public static detektif guwe = new detektif("/assets/character/detektif.jpg", "detektif", "Sensei");
    public static character mutsukiHappy = new character("/assets/character/mustuki_happy.png", "mutsuki");
    
    public static void main(String[] args) {
        
        new scene.HomeScreen.homeScreen().setVisible(true);
    }
}