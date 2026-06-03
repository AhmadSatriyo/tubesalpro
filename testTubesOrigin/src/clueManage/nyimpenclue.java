/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clueManage;
import java.util.ArrayList;
/**
 *
 * @author Mahesa Rahmat
 */
public class nyimpenclue {

    private static ArrayList<String> daftarClue = new ArrayList<>();

    public static void tambahClue(String clue){
        if(!daftarClue.contains(clue)){
            daftarClue.add(clue);
        }
    }

    public static ArrayList<String> getDaftarClue(){
        return daftarClue;
    }
}
