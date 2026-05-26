
package script;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class background {
    
    private String path;
    private String nama;
    
    // Constructor untuk menyimpan data path dan nama latar
    public background(String path, String nama) {
        this.path = path;
        this.nama = nama;
    }
    
    // KUNCI PERBAIKAN: Buang kata 'static'. 
    // Sekarang method ini tidak perlu minta parameter String path lagi dari luar!
    public ImageIcon ambilGambar(JLabel labelTujuan) {
        try {
            // Menggunakan 'this.path' yang didapat dari constructor saat bikin object
            URL imgURL = getClass().getResource(this.path);
            
            if (imgURL != null) {
                ImageIcon iconMentah = new ImageIcon(imgURL);
                
                int lebar = labelTujuan.getWidth();
                int tinggi = labelTujuan.getHeight();
                
                if (lebar <= 0) lebar = 800; 
                if (tinggi <= 0) tinggi = 600;
                
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

    // Getter dan Setter
    public String getPath() { return path; }
    public String getNama() { return nama; }
    public void setPath(String path) { this.path = path; }
    public void setNama(String nama) { this.nama = nama; }
}