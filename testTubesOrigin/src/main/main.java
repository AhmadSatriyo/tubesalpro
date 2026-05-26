package main;

import script.background;
import script.character;
import script.detektif;

public class Main {
    
    
    public static background bgTangga = new background("/assets/background/tangga.jpg", "Latar Tangga");
    public static detektif guwe = new detektif("/assets/background/detektif.jpg", "detektif", "Sensei");
    
    public static void main(String[] args) {
        
        new scene.HomeScreen.homeScreen().setVisible(true);
    }
}