package script;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class character {
    
    private String path;
    private String nama;
    
    // UKURAN FIX STANDAR VISUAL NOVEL (RESOLUSI 1920 x 1080)
    private static final int FIX_LEBAR = 500;
    private static final int FIX_TINGGI = 850;
    
    public character(String path, String nama) {
        this.path = path;
        this.nama = nama;
    }
    
    public ImageIcon ambilGambar(JLabel labelTujuan) {
        try {
            URL imgURL = getClass().getResource(this.path);
            
            if (imgURL != null) {
                ImageIcon iconMentah = new ImageIcon(imgURL);
                
                // 1. Paksa ukuran JLabel tujuan agar pas dengan dimensi karakter VN
                labelTujuan.setSize(FIX_LEBAR, FIX_TINGGI);
                
                // 2. Lakukan resize gambar menggunakan konstanta ukuran fix
                Image imgResize = iconMentah.getImage().getScaledInstance(
                    FIX_LEBAR, 
                    FIX_TINGGI, 
                    Image.SCALE_SMOOTH
                );
                
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