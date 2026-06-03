
package scene.environment.temaCastle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;
import script.Transisi;
import script.posisi;
import clueManage.bukuclueFrame;
/**
 *
 * @author ryo
 */
public class kamarScene extends javax.swing.JFrame {

    private String temaTerpilih;
    
    private posisi posisiBukuClue;
    private posisi posisiBukuTersangka;
    private posisi posisiPetaKastil;
    private posisi posisiButtonIstirahat;
    private posisi posisiButtonLanjutkanInvestigasi;
    private posisi posisiButtonBack;
    
    private boolean sudahMilihLokasi = false;
    private int pilihan = -1;
    private boolean modeStory = true;
    
    String[] lokasi = {"Perpustakaan", "Kamar Aldric Jr.", "Kamar Caelan", "Kamar Erian", "Kamar Dorian"};
    
    private int opsi;

    /**
     * Creates new form kamarScene
     */
    public kamarScene() {
        this.setUndecorated(true);
        
        initComponents();
        setExtendedState(kamarScene.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
        
        ImageIcon backgroundKamarScene = Global.backgoundKamarScene.ambilGambar(background);
        background.setIcon(backgroundKamarScene);
        
        posisiBukuClue = new posisi(panelBukuClue);
        posisiBukuTersangka = new posisi(panelBukuTersangka);
        posisiPetaKastil = new posisi(panelPetaKastil);
        posisiButtonIstirahat = new posisi(buttonIstirahat);
        posisiButtonLanjutkanInvestigasi = new posisi(buttonLanjutkanInvestigasi);
        posisiButtonBack = new posisi(buttonBack);
        
        
        aturPosisi();
        
        
        
    }
    
    private void aturPosisi() {
        
        posisiBukuClue.posisi(0, 300);
        posisiBukuClue.tengahHorizontal(this);
        
        posisiBukuTersangka.posisi(1000, 300);
        
        posisiPetaKastil.posisi(500, 300);
        
        posisiButtonLanjutkanInvestigasi.posisi(0, 600);
        posisiButtonLanjutkanInvestigasi.tengahHorizontal(this);
        
        posisiButtonIstirahat.posisi(0, 650);
        posisiButtonIstirahat.tengahHorizontal(this);
        
        posisiButtonBack.kananBawah(this);
    }
    
    private void bukaPetaMisteri(int pilihanKe) {
        // Tampilkan transisi sela / resume info statistik sebelum pindah scene
        String namaTempat = lokasi[pilihanKe];
        String pesanTransisi = "=========================================\n"
                             + "       Chapter 2 - Menuju " + namaTempat + "\n"
                             + "=========================================\n\n"
                             + " Status Detektif Saat Ini:\n"
                             + " 🔋 Energi Kamu = " + main.Global.energi + "\n"
                             + " 🎯 Poin Clue   = " + main.Global.poinClue + "\n\n"
                             + "-----------------------------------------\n"
                             + "Klik OK...";
                             
//        JOptionPane.showMessageDialog(this, pesanTransisi, "Memulai Investigasi", JOptionPane.INFORMATION_MESSAGE);

        // Proses perpindahan scene berdasarkan lokasi terpilih
       
    }
    
    private void eksekusiPindahLokasi(int pilihanKe) {
    String namaTempat = lokasi[pilihanKe];
    String pesanTransisi = "=========================================\n"
                         + "       Chapter 2 - Menuju " + namaTempat + "\n"
                         + "=========================================\n\n"
                         + " Status Detektif Saat Ini:\n"
                         + " 🔋 Energi Kamu = " + main.Global.energi + "\n"
                         + " 🎯 Poin Clue   = " + main.Global.poinClue + "\n\n"
                         + "-----------------------------------------\n"
                         + "Klik OK untuk memulai investigasi...";
                         
    JOptionPane.showMessageDialog(this, pesanTransisi, "Memulai Investigasi", JOptionPane.INFORMATION_MESSAGE);

    // Proses perpindahan Form/Scene berdasarkan lokasi terpilih
    switch (pilihanKe) {
        case 0: // Perpustakaan
            script.Transisi.pindahScene(this, new scene.environment.temaCastle.perpustakaanScene());
            break;
        case 1: // Taman Istana
            // script.Transisi.pindahScene(this, new scene.environment.temaCastle.tamanScene());
            System.out.println("Menuju Taman Istana");
            System.exit(0);
            break;
        case 2: // Koridor Utama
            // script.Transisi.pindahScene(this, new scene.environment.temaCastle.koridorScene());
            break;
        case 3: // Gedung Arsip
            // script.Transisi.pindahScene(this, new scene.environment.temaCastle.gedungArsipScene());
            break;
        case 4: // Batalyon Ksatria
            // script.Transisi.pindahScene(this, new scene.environment.temaCastle.batalyonScene());
            break;
        default:
            break;
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonIstirahat = new javax.swing.JButton();
        buttonLanjutkanInvestigasi = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        panelBukuTersangka = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBukuClue = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelPetaKastil = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonIstirahat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonIstirahat.setText("istirahat");
        buttonIstirahat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIstirahatActionPerformed(evt);
            }
        });
        getContentPane().add(buttonIstirahat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 330, 40));

        buttonLanjutkanInvestigasi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonLanjutkanInvestigasi.setText("lanjutkan investigasi");
        buttonLanjutkanInvestigasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLanjutkanInvestigasiActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLanjutkanInvestigasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 330, 40));

        buttonBack.setText("menu");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        getContentPane().add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 213, 110, 50));

        panelBukuTersangka.setBackground(new java.awt.Color(29, 38, 64));
        panelBukuTersangka.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelBukuTersangka.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBukuTersangkaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBukuTersangkaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBukuTersangkaMouseExited(evt);
            }
        });
        panelBukuTersangka.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BUKU TERSANGKA");
        jLabel3.setToolTipText("");
        panelBukuTersangka.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/kampus.jpeg"))); // NOI18N
        panelBukuTersangka.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        getContentPane().add(panelBukuTersangka, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 180, 240));

        panelBukuClue.setBackground(new java.awt.Color(29, 38, 64));
        panelBukuClue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelBukuClue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBukuClueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBukuClueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBukuClueMouseExited(evt);
            }
        });
        panelBukuClue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BUKU CLUE");
        jLabel5.setToolTipText("");
        panelBukuClue.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/Sunset Castle.jpeg"))); // NOI18N
        panelBukuClue.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        getContentPane().add(panelBukuClue, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 180, 240));

        panelPetaKastil.setBackground(new java.awt.Color(29, 38, 64));
        panelPetaKastil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelPetaKastil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPetaKastilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelPetaKastilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelPetaKastilMouseExited(evt);
            }
        });
        panelPetaKastil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/orient express.jpeg"))); // NOI18N
        panelPetaKastil.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PETA KASTIL");
        jLabel7.setToolTipText("");
        panelPetaKastil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, 30));

        getContentPane().add(panelPetaKastil, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 180, 240));

        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, -90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelPetaKastilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPetaKastilMouseClicked
        // TODO add your handling code here:
        
        if(!Global.modeBebas) {
        JOptionPane.showMessageDialog(this, "Selesaikan mode cerita terlebih dahulu", "Tic-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    else {
        pilihan = JOptionPane.showOptionDialog(
            this,
            "Pilih lokasi yang ingin kamu investigasi hari ini:",
            "Peta Kerajaan - Hari " + main.Global.hari,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            lokasi,
            lokasi[0]
        );  
        
        // 🔥 VALIDASI: Jika user menekan tombol 'X' (Cancel), batalkan status pilih
        if (pilihan == JOptionPane.CLOSED_OPTION) {
            sudahMilihLokasi = false;
            pilihan = -1; // Reset pilihan
        } else {
            sudahMilihLokasi = true; // Set true HANYA jika lokasi valid dipilih
            System.out.println("Lokasi disiapkan: " + lokasi[pilihan]);
        }
    }
    
    // Mengatur warna border visual card
    panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
    panelBukuClue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
    panelPetaKastil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelPetaKastilMouseClicked

    private void panelPetaKastilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPetaKastilMouseEntered
        // TODO add your handling code here:
        panelPetaKastil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelPetaKastilMouseEntered

    private void panelPetaKastilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPetaKastilMouseExited
        panelPetaKastil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
        if (opsi != 1) {
        panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        }
    }//GEN-LAST:event_panelPetaKastilMouseExited

    private void panelBukuClueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuClueMouseClicked
        // TODO add your handling code here:
        opsi = 2;

        // Kunci border Castle jadi menyala (Biru), matikan border card lainnya
        panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelBukuClue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
        panelPetaKastil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        
        bukuclueFrame bukuclue = new bukuclueFrame();
        bukuclue.setVisible(true);

    }//GEN-LAST:event_panelBukuClueMouseClicked

    private void panelBukuClueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuClueMouseEntered
        // TODO add your handling code here:
        panelBukuClue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelBukuClueMouseEntered

    private void panelBukuClueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuClueMouseExited
        // TODO add your handling code here:
        panelBukuClue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));

        if (opsi != 2) {
            panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        }
    }//GEN-LAST:event_panelBukuClueMouseExited

    private void panelBukuTersangkaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuTersangkaMouseClicked

        opsi = 3;

        panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
        panelBukuClue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelPetaKastil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));

    }//GEN-LAST:event_panelBukuTersangkaMouseClicked

    private void panelBukuTersangkaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuTersangkaMouseEntered
        // TODO add your handling code here:
        panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelBukuTersangkaMouseEntered

    private void panelBukuTersangkaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBukuTersangkaMouseExited
        // TODO add your handling code here:
        panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));

        if (opsi != 3) {
            panelBukuTersangka.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        }
    }//GEN-LAST:event_panelBukuTersangkaMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        aturPosisi();
    }//GEN-LAST:event_formWindowOpened

    private void buttonLanjutkanInvestigasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLanjutkanInvestigasiActionPerformed
        if(!Global.modeBebas) {
        main.Global.chapter1 = true;
        script.Transisi.pindahScene(this, new scene.environment.temaCastle.transisiChapter1());
    }
    else {
        // 🔥 VALIDASI UTAMA: Jika belum memilih lokasi di peta, cegah masuk!
        if (!sudahMilihLokasi || pilihan == -1) {
            JOptionPane.showMessageDialog(this, 
                "Kamu harus memilih salah satu lokasi di Peta Kastil terlebih dahulu sebelum melanjutkan investigasi!", 
                "Tujuan Belum Ditentukan", 
                JOptionPane.WARNING_MESSAGE);
            return; 
        }
        
        // Lolos validasi, panggil fungsi pengalihan scene beserta transisinya
        eksekusiPindahLokasi(pilihan);
    }
    }//GEN-LAST:event_buttonLanjutkanInvestigasiActionPerformed

    private void buttonIstirahatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIstirahatActionPerformed
        
        if(!Global.modeBebas) {
            JOptionPane.showMessageDialog(this, "Selesaikan mode cerita terlebih dahulu", "Mode Terkunci", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else {
            // Logika istirahat ganti hari
        }
    
    }//GEN-LAST:event_buttonIstirahatActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_buttonBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kamarScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kamarScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kamarScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kamarScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kamarScene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonIstirahat;
    private javax.swing.JButton buttonLanjutkanInvestigasi;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelBukuClue;
    private javax.swing.JPanel panelBukuTersangka;
    private javax.swing.JPanel panelPetaKastil;
    // End of variables declaration//GEN-END:variables
}
