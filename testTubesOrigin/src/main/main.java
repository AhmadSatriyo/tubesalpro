package main;

import script.background;

public class Main {
    
    
    public static background bgTangga = new background("/assets/background/tangga.jpg", "Latar Tangga");
    
    public static void main(String[] args) {
        
        new scene.HomeScreen.homeScreen().setVisible(true);
    }
}