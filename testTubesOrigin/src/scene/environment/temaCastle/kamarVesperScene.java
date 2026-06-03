/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package scene.environment.temaCastle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;
import script.posisi;
import clueManage.nyimpenclue;
/**
 *
 * @author ryo
 */
public class kamarVesperScene extends javax.swing.JFrame {
    
    private posisi posisiBackgroundDialog;
    private posisi posisiMC;
    private posisi posisiVesper;
    private posisi posisiMatthias;
    private posisi posisiBoxDialog;
    private String teks;
    private posisi posisiLabelNama;
    private posisi posisiButton1;
    private posisi posisiButton2;
    private posisi posisiButton3;
    
    private int opsi = 0;

    public kamarVesperScene() {
        this.setUndecorated(true);
        
        initComponents();
        Global.initCeritaGame(); 
        setExtendedState(kamarVesperScene.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);

        ImageIcon backgroundKamarVesperScene = Global.backgroundKamarVesperScene.ambilGambar(background);
        background.setIcon(backgroundKamarVesperScene);
        
    boxDialog.setEditable(false);         // Teks tidak bisa diedit/dihapus
    boxDialog.setHighlighter(null);       // Teks tidak bisa diblok/diseleksi warna biru
    boxDialog.setFocusable(false);        // JTextArea tidak bisa menerima fokus klik mouse
    boxDialog.setCursor(null);            // Mengubah kursor [I] jadi kursor panah biasa
    boxDialog.setBackground(new java.awt.Color(0, 0, 0, 0)); // Transparan
    
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
    
    // 3. Set Ukuran Komponen Secara Manual (Agar class posisi tidak salah hitung lebar)
    boxDialog.setSize(800, 250);          // Sesuaikan lebar & tinggi kotak teks game kamu
    
    ImageIcon detektif = main.Global.guwe.ambilGambar(detektifSprite);
    detektifSprite.setIcon(detektif);
    
    ImageIcon vesper = main.Global.Vesper.ambilGambar(vesperSprite);
    vesperSprite.setIcon(vesper);
    
    matthiasSprite.setVisible(false);
    
    ImageIcon matthias = main.Global.Matthias.ambilGambar(matthiasSprite);
    matthiasSprite.setIcon(matthias);
    
    // 5. Inisialisasi & Eksekusi Class Posisi
    posisiMC = new script.posisi(detektifSprite);
    posisiBackgroundDialog = new script.posisi(backgroundDialog);
    posisiBoxDialog = new script.posisi(boxDialog);
    posisiVesper = new posisi(vesperSprite);
    posisiMatthias = new posisi(matthiasSprite);
    posisiLabelNama = new posisi(labelNama);
    posisiButton1 = new posisi(button1);
    posisiButton2 = new posisi(button2);
    posisiButton3 = new posisi(button3);
    
    // Atur posisi posisi VN (Misal: detektif berdiri di kiri bawah)
    posisiMC.kiriBawah(this); 
    posisiVesper.kananBawah(this);
    posisiMatthias.kananBawah(this);
    
    // Jalankan method custom bawaan kamu
    aturPosisi(); 
    
     // 2. Alur Inisialisasi Data Dialog
    main.Global.indeksDialog = 0;       // Mulai dari awal dialog (indeks 0)
    tampilkanDialogSekarang();            // Tampilkan teks pertama ke boxDialog
    
    // =========================================================================
    // FILTER KEYBOARD: Jalankan Dialog via Tombol SPACE
    // =========================================================================
    this.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                mouseClicked(null);
            }
        }
    });
    this.setFocusable(true);
    this.requestFocusInWindow();
    
    
   
        
    }
    
    private void aturPosisi() {
        posisiMC.posisi(0, 200);
        posisiMC.kiriBawah(this);
        
        posisiVesper.posisi(0, 200);
        posisiVesper.kananBawah(this);
        
        posisiMatthias.posisi(0, 200);
        posisiMatthias.kananBawah(this);
        
        posisiBackgroundDialog.aturSebagaiBackgroundDialog(this);
        
        posisiBoxDialog.aturSebagaiBoxDialog(this);
        
        posisiLabelNama.aturSebagaiLabelNama();
        
        posisiButton1.posisi(0, 300);
        posisiButton1.tengahHorizontal(this);
        posisiButton2.posisi(0, 350);
        posisiButton2.tengahHorizontal(this);
        posisiButton3.posisi(0, 400);
        posisiButton3.tengahHorizontal(this);
        
    }
    
    private void tampilkanDialogSekarang() {
        
        script.Dialog d = main.Global.dialogVesperChapter1[main.Global.indeksDialog];

    // Pasang nama pembicara ke JLabel nama
        labelNama.setText(d.getNama());
        
        if (d.getNama().equals(Global.Vesper.getNama())) {
//            // Jika Dorian yang ngomong, posisi objek dorian memicu efek loncat ke JLabel gambarnya
//            posisiVesper.bicaraLoncat(vesperSprite, vesperSprite.getWidth(), vesperSprite.getHeight()); 
        } 
        else if (d.getNama().equals(Global.guwe.getNama())) {
//            posisiMC.bicaraLoncat(detektifSprite, detektifSprite.getWidth(), detektifSprite.getHeight());
    }

    // Pasang isi teks ke JLabel/boxText kamu (Pakai HTML biar otomatis center & wrap)
        
        
        
       
        boxDialog.setText(d.getTeks());
    }
    
    private void tampilkanDialogOpsiSekarang(script.Dialog[] arrayOpsi) {
    // Ambil dialog dari arrayOpsi yang dikirim sesuai indeksDialog saat ini
    script.Dialog dialogAktif = arrayOpsi[main.Global.indeksDialog];
    
    // Set teks ke UI
    labelNama.setText(dialogAktif.getNama());
    boxDialog.setText(dialogAktif.getTeks());
    
    // Efek loncat animasi (opsional, bisa kamu aktifkan nanti)
    if (dialogAktif.getNama().equals(Global.guwe.getNama())) {
        // posisiMC.bicaraLoncat(detektifSprite, detektifSprite.getWidth(), detektifSprite.getHeight());
    }
    else if (dialogAktif.getNama().equals(Global.Matthias.getNama())) {
        vesperSprite.setVisible(false);
        matthiasSprite.setVisible(true);
    }
    else if (dialogAktif.getNama().equals(Global.Vesper.getNama())) {
        vesperSprite.setVisible(true);
        matthiasSprite.setVisible(false);
    }
}
    
    private void mouseClicked(java.awt.event.MouseEvent evt) {                              
        
        
        switch(opsi) {
        case 0 : // JALUR UTAMA
            if (main.Global.indeksDialog < main.Global.dialogVesperChapter1.length - 1) {
                main.Global.indeksDialog++; 
                tampilkanDialogSekarang();    
            } else {
                button1.setVisible(true);
                button2.setVisible(true);
                button3.setVisible(true);
            }
            break;
            
        case 1 : // JALUR OPSI 1
            if (main.Global.indeksDialog < main.Global.dialogVesperChapter1Opsi1.length - 1) {
                main.Global.indeksDialog++; 
                tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi1); 
            } else {
                System.out.println("Cerita Opsi 1 Selesai! Pindah Scene berikutnya.");
                
                // PANGGIL POP-UP POIN DI SINI (Misal Opsi 1 dapet 3 poin)
                beriPoinPercakapan("Melihat Kamar Raja", 0);
                nyimpenclue.tambahClue("Kamar Raja");
                script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarRajaScene());
            }
            break;
            
        case 2 : // JALUR OPSI 2
            if (main.Global.indeksDialog < main.Global.dialogVesperChapter1Opsi2.length - 1) {
                main.Global.indeksDialog++; 
                tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi2); 
            } else {
                System.out.println("Cerita Opsi 2 Selesai! Pindah Scene berikutnya.");
                

                beriPoinPercakapan("Interogasi Alibi Vesper", 2);
                nyimpenclue.tambahClue("Vesper mengaku sedang berada di perpustakaan saat Raja ditemukan tewas.");

                script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarRajaScene());
            }
            break;
            
        case 3 : // JALUR OPSI 3
            if (main.Global.indeksDialog < main.Global.dialogVesperChapter1Opsi3.length - 1) {
            main.Global.indeksDialog++; 
            tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi3); 
            } else {
            System.out.println("Cerita Opsi 3 Selesai! Pindah Scene berikutnya.");

            // simpan pilihan player
            main.Global.opsiCeritaKamarVesper = 3;

            // kunci energi tetap
            main.Global.energi = 5;

            // kasih poin percakapan
            beriPoinPercakapan("Mencari Matthias", 3);

            // tambah clue penting
            nyimpenclue.tambahClue(
                "Menurut Vesper, Matthias adalah orang terakhir yang bertemu Raja malam itu."
            );

        // pindah scene
        script.Transisi.pindahScene(
            this,
            new scene.environment.temaCastle.kamarRajaScene()
        );
    }
    break;
        }
        
        
    }
    
    private void beriPoinPercakapan(String namaOpsi, int tambahPoin) {
    // Tambahkan poin ke database global
    main.Global.poinClue += tambahPoin;
    
    // Kunci energi tetap di angka 5 sesuai request
    main.Global.energi = 5; 
    
    // Susun pesan informasi untuk pop-up info statistik
    String pesan = "[INFORMASI - CERITA]\n"
                 + "Rute: " + namaOpsi + "\n\n"
                 + "Hasil Percakapan:\n"
                 + "Kamu mendapatkan petunjuk baru dari kesaksian! (+" + tambahPoin + " Poin)\n"
                 + "--------------------------------------------------\n"
                 + "Poin saat ini   = " + main.Global.poinClue + "\n"
                 + "Energi saat ini = " + main.Global.energi;
                 
    JOptionPane.showMessageDialog(this, pesan, "Kesaksian Dicatat", JOptionPane.INFORMATION_MESSAGE);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        boxDialog = new javax.swing.JTextArea();
        backgroundDialog = new javax.swing.JLabel();
        matthiasSprite = new javax.swing.JLabel();
        vesperSprite = new javax.swing.JLabel();
        detektifSprite = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.setText("Periksa kamar raja");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 330, 40));

        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.setText("Tanya lebih jauh");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 330, 40));

        button3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button3.setText("Temui Matthias");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 330, 40));

        labelNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNama.setForeground(new java.awt.Color(0, 0, 0));
        labelNama.setText("dummyyyyyyyyyyyyyyyy");
        getContentPane().add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 730, 200, 50));

        boxDialog.setEditable(false);
        boxDialog.setColumns(5);
        boxDialog.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxDialog.setForeground(new java.awt.Color(0, 0, 0));
        boxDialog.setRows(5);
        boxDialog.setText("\nsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        boxDialog.setBorder(null);
        getContentPane().add(boxDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 900, 190));

        backgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/dialogueBox.png"))); // NOI18N
        getContentPane().add(backgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 720, 1000, 270));
        getContentPane().add(matthiasSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));
        getContentPane().add(vesperSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));
        getContentPane().add(detektifSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));

        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        aturPosisi();
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        mouseClicked(null);
    }//GEN-LAST:event_formMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        this.opsi = 1; 
        Global.opsiCeritaKamarVesper = 1;
        
        // Reset indeks kembali ke 0 untuk membaca array baru
        main.Global.indeksDialog = 0;
        
        // Sembunyikan semua tombol pilihan kembali
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        
        // Tampilkan dialog pertama dari rute Opsi 1
        tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi1);
        
        // Kembalikan fokus ke Frame agar tombol SPACE tetap berfungsi setelah klik button
        this.requestFocusInWindow();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        this.opsi = 2; 
        Global.opsiCeritaKamarVesper = 2;
        
        // Reset indeks kembali ke 0 untuk membaca array baru
        main.Global.indeksDialog = 0;
        
        // Sembunyikan semua tombol pilihan kembali
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        
        // Tampilkan dialog pertama dari rute Opsi 1
        tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi2);
        
        // Kembalikan fokus ke Frame agar tombol SPACE tetap berfungsi setelah klik button
        this.requestFocusInWindow();
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        this.opsi = 3; 
        Global.opsiCeritaKamarVesper = 3;
        
        // Reset indeks kembali ke 0 untuk membaca array baru
        main.Global.indeksDialog = 0;
        
        // Sembunyikan semua tombol pilihan kembali
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        
        // Tampilkan dialog pertama dari rute Opsi 1
        tampilkanDialogOpsiSekarang(main.Global.dialogVesperChapter1Opsi3);
        
        // Kembalikan fokus ke Frame agar tombol SPACE tetap berfungsi setelah klik button
        this.requestFocusInWindow();
    }//GEN-LAST:event_button3ActionPerformed

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
            java.util.logging.Logger.getLogger(kamarVesperScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kamarVesperScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kamarVesperScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kamarVesperScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kamarVesperScene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundDialog;
    private javax.swing.JTextArea boxDialog;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JLabel detektifSprite;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel matthiasSprite;
    private javax.swing.JLabel vesperSprite;
    // End of variables declaration//GEN-END:variables
}
