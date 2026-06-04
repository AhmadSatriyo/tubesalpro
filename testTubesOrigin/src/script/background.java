
package script;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class background {
    
    private String path;
    private String nama;
    
    public background(String path, String nama) {
        this.path = path;
        this.nama = nama;
    }
    

    public ImageIcon ambilGambar(JLabel labelTujuan) {
        
        try {
            URL imgURL = getClass().getResource(this.path);
            
            if (imgURL != null) {
                ImageIcon iconMentah = new ImageIcon(imgURL);
                
                int lebar = labelTujuan.getWidth();
                int tinggi = labelTujuan.getHeight();
                
                if (lebar <= 0) lebar = 1920; 
                if (tinggi <= 0) tinggi = 1080;
                
                Image imgResize = iconMentah.getImage().getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);
                return new ImageIcon(imgResize);
            } else {
                System.err.println("Aset [" + this.nama + "] tidak ditemukan pada: " + this.path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPath() { return path; }
    public String getNama() { return nama; }
    public void setPath(String path) { this.path = path; }
    public void setNama(String nama) { this.nama = nama; }
}