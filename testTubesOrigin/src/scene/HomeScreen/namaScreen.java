
package scene.HomeScreen;

import script.posisi;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;


public class namaScreen extends javax.swing.JFrame {
    
    private posisi teksTittle;
    private posisi textFieldNama;
    private posisi backgroundTFNama;
    private posisi btnStart;
    private posisi btnQuit;
    private posisi textMasukkanNama;

    public namaScreen() {
        
        this.setUndecorated(true);
        
        initComponents();
        setExtendedState(namaScreen.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
        
        textFieldNama = new posisi(boxNama);
        backgroundTFNama = new posisi(textBoxBackground);

        ImageIcon homeScreenBackground = Global.homeScreenBackground.ambilGambar(background);
        background.setIcon(homeScreenBackground);
        
        ImageIcon boxPict = Global.textBoxBackground.ambilGambar(textBoxBackground);
        textBoxBackground.setIcon(boxPict);
        
        boxNama.setOpaque(false);
        boxNama.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        boxNama.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        teksTittle = new posisi(labelTittle);
        btnStart = new posisi(buttonStart);
        btnQuit = new posisi(buttonQuit);
        textMasukkanNama = new posisi(labelMasukkanNama);
        
        aturPosisiKomponen();
    }
    
    private void cekDanKirimNama() {
        
        if(!boxNama.getText().equals("")) {
            // 1. Ambil input nama user
    Global.masukanNamaPlayer(boxNama.getText());
    
    // 2. TIMPA DAN GENERATE ULANG ISI ARRAY DENGAN NAMA BARU (WAJIB ADA!)
    Global.initCeritaGame(); 
    
    // 3. Pindah scene berikutnya
    script.Transisi.pindahScene(this, new scene.ThemeScreen.theme());
        }
        else {
            JOptionPane.showMessageDialog(this, "Mohon isi nama terlebih dahulu", "Tic-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
    
    private void aturPosisiKomponen() {
        
        labelTittle.setLocation(0, 100);
        teksTittle.tengahHorizontal(this);
        
        btnStart.posisi(640, 670); 
        btnQuit.posisi(900, 670);
        
        textMasukkanNama.posisi(0, 480);
        textMasukkanNama.tengahHorizontal(this);
        
        boxNama.setLocation(0, 520);
        textFieldNama.tengahHorizontal(this);
        
        textBoxBackground.setLocation(0, 400);
        backgroundTFNama.tengahHorizontal(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        buttonQuit = new javax.swing.JButton();
        buttonStart = new javax.swing.JButton();
        boxNama = new javax.swing.JTextField();
        labelMasukkanNama = new javax.swing.JLabel();
        textBoxBackground = new javax.swing.JLabel();
        labelTittle = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setName("frameAwal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUtama.setBackground(new java.awt.Color(204, 204, 204));
        panelUtama.setPreferredSize(new java.awt.Dimension(1920, 1080));
        panelUtama.setLayout(null);

        buttonQuit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonQuit.setText("Kembali");
        buttonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitActionPerformed(evt);
            }
        });
        panelUtama.add(buttonQuit);
        buttonQuit.setBounds(690, 320, 140, 70);

        buttonStart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        panelUtama.add(buttonStart);
        buttonStart.setBounds(680, 220, 140, 70);

        boxNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        boxNama.setHighlighter(null);
        boxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNamaActionPerformed(evt);
            }
        });
        panelUtama.add(boxNama);
        boxNama.setBounds(630, 550, 480, 80);

        labelMasukkanNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMasukkanNama.setText("Masukkan Nama : ");
        panelUtama.add(labelMasukkanNama);
        labelMasukkanNama.setBounds(420, 190, 160, 25);
        panelUtama.add(textBoxBackground);
        textBoxBackground.setBounds(590, 390, 560, 280);

        labelTittle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTittle.setText("ini tittle");
        panelUtama.add(labelTittle);
        labelTittle.setBounds(320, 270, 179, 64);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/Fantasy Medieval Castle Wallpaper 4K.jpeg"))); // NOI18N
        panelUtama.add(background);
        background.setBounds(0, 0, 1920, 1080);

        getContentPane().add(panelUtama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        aturPosisiKomponen();
    }//GEN-LAST:event_formWindowOpened

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        
        cekDanKirimNama();
        
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitActionPerformed
        
        script.Transisi.pindahScene(this, new scene.HomeScreen.homeScreen());
        
    }//GEN-LAST:event_buttonQuitActionPerformed

    private void boxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNamaActionPerformed

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
            java.util.logging.Logger.getLogger(namaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(namaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(namaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(namaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new namaScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField boxNama;
    private javax.swing.JButton buttonQuit;
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel labelMasukkanNama;
    private javax.swing.JLabel labelTittle;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JLabel textBoxBackground;
    // End of variables declaration//GEN-END:variables
}
