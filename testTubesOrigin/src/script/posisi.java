package script;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class posisi {

    private JComponent component;
    private int xPermanen = -1;
    private int yPermanen = -1;
    private Timer timerLoncat = null; 

    public posisi(JComponent component) {

        this.component = component;
    }

    public void tengahHorizontal(JFrame frame) {

        int x =
            (frame.getWidth()
            - component.getWidth()) / 2;

        component.setLocation(
            x,
            component.getY()
        );
    }

    public void tengahVertical(JFrame frame) {

        int y =
            (frame.getHeight()
            - component.getHeight()) / 2;

        component.setLocation(
            component.getX(),
            y
        );
    }

    public void tengah(JFrame frame) {

        int x =
            (frame.getWidth()
            - component.getWidth()) / 2;

        int y =
            (frame.getHeight()
            - component.getHeight()) / 2;

        component.setLocation(x, y);
    }

    public void posisi(int x, int y) {

        component.setLocation(x, y);
    }
    public void kiriBawah(JFrame frame) {
        int x = 50; 
                
        component.setLocation(x, component.getY());
    }

    public void kananBawah(JFrame frame) {
        int x = frame.getWidth() - component.getWidth() - 50;
        
        
        component.setLocation(x,component.getY());
    }

    public void tengahBawah(JFrame frame) {
        int x = (frame.getWidth() - component.getWidth()) / 2;
        
        int y = frame.getHeight() - component.getHeight();
        
        component.setLocation(x, y);
    }
    
    public void aturSebagaiBackgroundDialog(javax.swing.JFrame frame) {
        this.posisi(0, 650);
        this.tengahHorizontal(frame);
    }

    public void aturSebagaiBoxDialog(javax.swing.JFrame frame) {
        this.posisi(0, 730);
        this.tengahHorizontal(frame);
    }


    public void aturSebagaiLabelNama() {
        this.posisi(420, 650);
    }
    
    public void bicaraLoncat(final javax.swing.JComponent komponenKarakter, final int lebarKarakter, final int tinggiKarakter) {
        
        final int xTanahAktif = komponenKarakter.getX(); 
        final int yTanahAktif = (yPermanen == -1) ? komponenKarakter.getY() : yPermanen;
        
        if (yPermanen == -1) {
            yPermanen = komponenKarakter.getY();
        }
        
        if (timerLoncat != null && timerLoncat.isRunning()) {
            timerLoncat.stop();
            komponenKarakter.setBounds(xTanahAktif, yTanahAktif, lebarKarakter, tinggiKarakter);
        }
        
        final int tinggiMaksimalLoncat = 15;
        final int kecepatan = 3;
        
        timerLoncat = new Timer(15, new ActionListener() {
            int ySekarang = yTanahAktif;
            boolean sedangNaik = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sedangNaik) {
                    ySekarang -= kecepatan;
                    if (ySekarang <= (yTanahAktif - tinggiMaksimalLoncat)) {
                        sedangNaik = false;
                    }
                } else {
                    ySekarang += kecepatan;
                    if (ySekarang >= yTanahAktif) {
                        ySekarang = yTanahAktif;
                        komponenKarakter.setBounds(xTanahAktif, ySekarang, lebarKarakter, tinggiKarakter);
                        ((Timer)e.getSource()).stop();
                        return;
                    }
                }
                komponenKarakter.setBounds(xTanahAktif, ySekarang, lebarKarakter, tinggiKarakter);
            }
        });
        
        timerLoncat.start();
    }
}