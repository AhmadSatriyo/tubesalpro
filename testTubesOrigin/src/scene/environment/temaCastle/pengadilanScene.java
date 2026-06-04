/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package scene.environment.temaCastle;

import main.Global;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import script.posisi;
/**
 *
 * @author ryo
 */
public class pengadilanScene extends javax.swing.JFrame {

    /**
     * Creates new form pengadilanScene
     */
    private posisi posisiBackgroundDialog;
    private posisi posisiMC;
    private posisi posisiCaelan;
    private posisi posisiDorian;
    private posisi posisiAldric;
    private posisi posisiVesper;
    private posisi posisiBoxDialog;
    private posisi posisiLabelNama;
    private posisi posisiButtonCaelan;
    private posisi posisiButtonDorian;
    private posisi posisiButtonAldric;
    private posisi posisiButtonVesper;
    
    private int spriteAktif = 0;
    
    public pengadilanScene() {
        this.setUndecorated(true);
        initComponents();
        
        Global.initCeritaGame();
        setExtendedState(pengadilanScene.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);

        // === PASANG BACKGROUND ===
        ImageIcon bg = Global.backgroundPengadilanScene.ambilGambar(background);
        background.setIcon(bg);

        // === SETTING BOX DIALOG ===
        boxDialog.setEditable(false);
        boxDialog.setHighlighter(null);
        boxDialog.setFocusable(false);
        boxDialog.setCursor(null);
        boxDialog.setBackground(new java.awt.Color(0, 0, 0, 0));
        
//        // Menghilangkan border scroll bawaan NetBeans agar transparan
//        jScrollPane1.setBorder(null);
//        jScrollPane1.setOpaque(false);
//        jScrollPane1.getViewport().setOpaque(false);

        // === PASANG SPRITE (Disesuaikan dengan variabel NetBeans barumu) ===
        ImageIcon imgMC = Global.guwe.ambilGambar(detektifSprite1);
        detektifSprite1.setIcon(imgMC);

        ImageIcon imgCaelan = Global.Caelan.ambilGambar(caelanSprite1);
        caelanSprite1.setIcon(imgCaelan);

        ImageIcon imgDorian = Global.Dorian.ambilGambar(dorianSprite1);
        dorianSprite1.setIcon(imgDorian);

        ImageIcon imgAldric = Global.AldricJr.ambilGambar(aldricSprite);
        aldricSprite.setIcon(imgAldric);

        ImageIcon imgVesper = Global.Vesper.ambilGambar(vesperSprite);
        vesperSprite.setIcon(imgVesper);

        // Sembunyikan semua sprite tersangka di awal
        sembunyikanSemuaSpriteTersangka();

        // Sembunyikan semua tombol pilihan di awal
        buttonCaelan.setVisible(false);
        buttonDorian.setVisible(false);
        buttonAldric.setVisible(false);
        buttonVesper.setVisible(false); 

        // === INISIALISASI POSISI (Target dipindah ke komponen baru) ===
        posisiMC              = new posisi(detektifSprite1);
        posisiCaelan          = new posisi(caelanSprite1);
        posisiDorian          = new posisi(dorianSprite1);
        posisiAldric          = new posisi(aldricSprite);
        posisiVesper          = new posisi(vesperSprite);
        posisiBackgroundDialog = new posisi(backgroundDialog);
        
        // PENTING: Target box dialog diubah ke JScrollPane agar kontainernya ikut bergeser
        posisiBoxDialog       = new posisi(boxDialog);
        posisiLabelNama       = new posisi(labelNama);
        posisiButtonCaelan    = new posisi(buttonCaelan);
        posisiButtonDorian    = new posisi(buttonDorian);
        posisiButtonAldric    = new posisi(buttonAldric);
        posisiButtonVesper    = new posisi(buttonVesper);

        posisiMC.kiriBawah(this);
        posisiCaelan.kananBawah(this);
        posisiDorian.kananBawah(this);
        posisiAldric.kananBawah(this);
        posisiVesper.kananBawah(this);

        aturPosisi();

        // === MULAI DIALOG ===
        main.Global.indeksDialog = 0;
        tampilkanDialogSekarang();

        // === KEYBOARD SPACE ===
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                    majuDialog();
                }
            }
        });
        this.setFocusable(true);
        this.requestFocusInWindow();
    
    }

    private void aturPosisi() {
        posisiMC.posisi(0, 200);
        posisiMC.kiriBawah(this);

        posisiCaelan.posisi(0, 200);
        posisiCaelan.kananBawah(this);

        posisiDorian.posisi(0, 200);
        posisiDorian.kananBawah(this);

        posisiAldric.posisi(0, 200);
        posisiAldric.kananBawah(this);

        posisiVesper.posisi(0, 200);
        posisiVesper.kananBawah(this);
        
        posisiBoxDialog.aturSebagaiBoxDialog(this);
        posisiBackgroundDialog.aturSebagaiBackgroundDialog(this);
        // === LANGSUNG AMBIL KOORDINAT DARI TAB DESIGN ===

        labelNama.setBounds(labelNama.getX(), labelNama.getY(), labelNama.getWidth(), labelNama.getHeight());
        // ===============================================

        // Posisi tombol tuduh (Tengah layar otomatis)
        posisiButtonCaelan.posisi(0, 300);
        posisiButtonCaelan.tengahHorizontal(this);
        posisiButtonDorian.posisi(0, 350);
        posisiButtonDorian.tengahHorizontal(this);
        posisiButtonAldric.posisi(0, 400);
        posisiButtonAldric.tengahHorizontal(this);
        posisiButtonVesper.posisi(0, 460); 
        posisiButtonVesper.tengahHorizontal(this);
    }

    private void tampilkanDialogSekarang() {
        script.Dialog d = main.Global.dialogPengadilan[main.Global.indeksDialog];
        boxDialog.setForeground(java.awt.Color.BLACK);
        
        labelNama.setText(d.getNama());
        boxDialog.setText(d.getTeks());

        // 1. Sembunyikan dulu semua sprite tersangka agar gantian munculnya
        sembunyikanSemuaSpriteTersangka();

        // 2. Cek siapa yang bicara, munculkan spritenya di posisi yang benar, lalu paksa ke depan layer
        if (d.getNama().equals(Global.guwe.getNamaPlayer())) {
            // MC bicara -> Tampilkan MC di kiri bawah
            detektifSprite1.setVisible(true);
            posisiMC.posisi(0, 200);
            posisiMC.kiriBawah(this);
            this.getContentPane().setComponentZOrder(detektifSprite1, 0);
        } 
        else if (d.getNama().equals(Global.Caelan.getNama())) {
            // Caelan bicara -> Tampilkan Caelan di kanan bawah
            caelanSprite1.setVisible(true);
            posisiCaelan.posisi(0, 200);
            posisiCaelan.kananBawah(this);
            this.getContentPane().setComponentZOrder(caelanSprite1, 0);
        } 
        else if (d.getNama().equals(Global.Dorian.getNama())) {
            // Dorian bicara -> Tampilkan Dorian di kanan bawah
            dorianSprite1.setVisible(true);
            posisiDorian.posisi(0, 200);
            posisiDorian.kananBawah(this);
            this.getContentPane().setComponentZOrder(dorianSprite1, 0);
        } 
        else if (d.getNama().equals(Global.AldricJr.getNama())) {
            // Aldric bicara -> Tampilkan Aldric di kanan bawah
            aldricSprite.setVisible(true);
            posisiAldric.posisi(0, 200);
            posisiAldric.kananBawah(this);
            this.getContentPane().setComponentZOrder(aldricSprite, 0);
        } 
        else if (d.getNama().equals(Global.Vesper.getNama())) {
            // Vesper bicara -> Tampilkan Vesper di kanan bawah
            vesperSprite.setVisible(true);
            posisiVesper.posisi(0, 200);
            posisiVesper.kananBawah(this);
            this.getContentPane().setComponentZOrder(vesperSprite, 0);
        }

        // 3. Jaga agar Box UI Dialog & Tombol tetap berada di lapisan paling depan agar tidak tertimbun
        this.getContentPane().setComponentZOrder(labelNama, 0);
        this.getContentPane().setComponentZOrder(boxDialog, 0); // <--- TARGET DIUBAH KE BOXDIALOG
        this.getContentPane().setComponentZOrder(backgroundDialog, 0);

        // 4. Refresh tampilan UI JFrame
        this.getContentPane().repaint();
        this.getContentPane().revalidate();
    }

    private void sembunyikanSemuaSpriteTersangka() {
        caelanSprite1.setVisible(false);
        dorianSprite1.setVisible(false);
        aldricSprite.setVisible(false);
        vesperSprite.setVisible(false);
    }

    private void majuDialog() {
        if (main.Global.indeksDialog < main.Global.dialogPengadilan.length - 1) {
            main.Global.indeksDialog++;
            tampilkanDialogSekarang();
        } else {
            // Dialog habis → tampilkan tombol pilihan tuduh
            munculkanTombolTuduh();
        }
    }

    private void munculkanTombolTuduh() {
        // Sembunyikan semua sprite, biarkan hanya MC
        sembunyikanSemuaSpriteTersangka();

        // Tampilkan pertanyaan di dialog box
        labelNama.setText(Global.guwe.getNamaPlayer());
        boxDialog.setText("Siapa... yang harus aku tuduh?");

        // Tampilkan 3 tombol utama
        buttonCaelan.setVisible(true);
        buttonDorian.setVisible(true);
        buttonAldric.setVisible(true);

        // Tombol Vesper hanya muncul jika tuduhVesper == true
        if (Global.tuduhVesper) {
            buttonVesper.setVisible(true);
        }
    }

    // =========================================================================
    // LOGIKA ENDING
    // =========================================================================

    private void prosesAkhir(String namaTertuduh) {
// 1. Sembunyikan semua elemen visual agar layar menjadi hitam total
        sembunyikanSemuaSpriteTersangka();
        detektifSprite1.setVisible(false);
        background.setIcon(null); // Menghapus gambar background panggung
        backgroundDialog.setIcon(null); // Menghapus gambar box dialog agar teks melayang di atas hitam
        
        // Sembunyikan tombol-tombol pilihan tuduh
        buttonCaelan.setVisible(false);
        buttonDorian.setVisible(false);
        buttonAldric.setVisible(false);
        buttonVesper.setVisible(false);

        // 2. Format ulang teks di boxDialog agar warnanya putih dan font-nya jelas di layar hitam
        boxDialog.setForeground(java.awt.Color.WHITE);
        boxDialog.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        
        // Hilangkan label nama (kosongkan)
        labelNama.setText("");

        // 3. Cek kondisi poin dan buat statistik ringkasnya
        String statistik = "\n\n---------------------------------------------\n"
                         + " STATISTIK INVESTIGASI\n"
                         + " Poin Clue yang Didapat: " + main.Global.poinClue + " / 25\n"
                         + " Tertuduh Pilihanmu    : " + namaTertuduh + "\n"
                         + "---------------------------------------------";

        // 4. Percabangan evaluasi ending
        if (main.Global.poinClue < 25) {
            tampilkanEndingLayarHitam("========== BAD ENDING: KEHABISAN WAKTU ==========\n\n"
                    + "Buktimu tidak cukup kuat untuk meyakinkan hakim.\n"
                    + "Sidang ditunda dan waktu investigasimu habis.\n\n"
                    + "Pembunuh raja yang asli tidak pernah ditemukan, dan\n"
                    + "Kerajaan Valdris jatuh ke tangan tirani yang salah." 
                    + statistik);
            return;
        }

        if (namaTertuduh.equals(Global.Vesper.getNama())) {
            tampilkanEndingLayarHitam("========== BEST ENDING: KEBENARAN SEJATI ==========\n\n"
                    + "\"Tuan Vesper... Kamulah dalang di balik semua ini!\"\n\n"
                    + "Keheningan mencekam memenuhi ruang sidang sebelum akhirnya Vesper\n"
                    + "mengaku karena semua bukti mutlak mengunci pergerakannya.\n\n"
                    + "Vesper berhasil ditangkap dan dieksekusi. Kerajaan aman!" 
                    + statistik);
            return;
        }

        if (namaTertuduh.equals(Global.tersangkaTerpilih[1].getNama())) {
            tampilkanEndingLayarHitam("========== NORMAL ENDING: SETENGAH KEBENARAN ==========\n\n"
                    + "Kamu berhasil menangkap " + namaTertuduh + " sebagai pelaku lapangan.\n"
                    + "Keadilan berhasil ditegakkan di mata publik.\n\n"
                    + "Namun di balik bayangan, sang dalang asli (Vesper) tersenyum puas\n"
                    + "karena posisinya sama sekali tidak tersentuh oleh hukum." 
                    + statistik);
            return;
        }

        // Jika salah tuduh total
        tampilkanEndingLayarHitam("========== WRONG ENDING: TRAGEDI SALAH TUDUH ==========\n\n"
                + "Kamu menjatuhkan tuduhan berat pada " + namaTertuduh + ".\n"
                + "Ruang sidang gempar karena bukti yang kamu bawa terkesan dipaksakan.\n\n"
                + "Orang yang tidak bersalah dijebloskan ke penjara, sementara sang\n"
                + "pembunuh asli menertawakan kebodohanmu dari kegelapan." 
                + statistik);
    }

    private void tampilkanEndingLayarHitam(String teksEnding) {
        // Cetak teks narasi penjelasannya langsung ke text area
        boxDialog.setText(teksEnding);
        
        // Buat text area meluas ke tengah layar agar mirip dengan konsep image_96001b.png
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCaelan = new javax.swing.JButton();
        buttonDorian = new javax.swing.JButton();
        buttonAldric = new javax.swing.JButton();
        buttonVesper = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        boxDialog = new javax.swing.JTextArea();
        backgroundDialog = new javax.swing.JLabel();
        aldricSprite = new javax.swing.JLabel();
        detektifSprite1 = new javax.swing.JLabel();
        caelanSprite1 = new javax.swing.JLabel();
        dorianSprite1 = new javax.swing.JLabel();
        vesperSprite = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonCaelan.setText("Caelan");
        buttonCaelan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCaelanActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCaelan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 220, 30));

        buttonDorian.setText("Dorian");
        buttonDorian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDorianActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDorian, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, 30));

        buttonAldric.setText("Aldric");
        buttonAldric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAldricActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAldric, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 220, 30));

        buttonVesper.setText("Vesper");
        buttonVesper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVesperActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVesper, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 220, 30));
        getContentPane().add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 160, 30));

        boxDialog.setColumns(20);
        boxDialog.setRows(5);
        getContentPane().add(boxDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 560, 150));

        backgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/dialogueBox.png"))); // NOI18N
        getContentPane().add(backgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 1230, 280));
        getContentPane().add(aldricSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 230, 400));
        getContentPane().add(detektifSprite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 130, 170));
        getContentPane().add(caelanSprite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 130, 170));
        getContentPane().add(dorianSprite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 130, 170));
        getContentPane().add(vesperSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 130, 170));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVesperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVesperActionPerformed
        // TODO add your handling code here:
        prosesAkhir(Global.Vesper.getNama());
    }//GEN-LAST:event_buttonVesperActionPerformed

    private void buttonCaelanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCaelanActionPerformed
        // TODO add your handling code here:
        prosesAkhir(Global.Caelan.getNama());
    }//GEN-LAST:event_buttonCaelanActionPerformed

    private void buttonDorianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDorianActionPerformed
        // TODO add your handling code here:
        prosesAkhir(Global.Dorian.getNama());
    }//GEN-LAST:event_buttonDorianActionPerformed

    private void buttonAldricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAldricActionPerformed
        // TODO add your handling code here:
        prosesAkhir(Global.AldricJr.getNama());
    }//GEN-LAST:event_buttonAldricActionPerformed

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
            java.util.logging.Logger.getLogger(pengadilanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengadilanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengadilanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengadilanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengadilanScene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aldricSprite;
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundDialog;
    private javax.swing.JTextArea boxDialog;
    private javax.swing.JButton buttonAldric;
    private javax.swing.JButton buttonCaelan;
    private javax.swing.JButton buttonDorian;
    private javax.swing.JButton buttonVesper;
    private javax.swing.JLabel caelanSprite1;
    private javax.swing.JLabel detektifSprite1;
    private javax.swing.JLabel dorianSprite1;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel vesperSprite;
    // End of variables declaration//GEN-END:variables
}
