
package scene.HomeScreen;

import script.posisi;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Main;


public class inputNamaScreen extends javax.swing.JFrame {
    
    private posisi teksTittle;
    private posisi textFieldNama;
    private posisi backgroundTFNama;
    private posisi btnStart;
    private posisi btnQuit;
    private posisi btnSetting;

    public inputNamaScreen() {
        
        initComponents();
        setExtendedState(inputNamaScreen.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
        
        textFieldNama = new posisi(boxNama);
        backgroundTFNama = new posisi(textBoxBackground);

        ImageIcon homeScreenBackground = Main.homeScreenBackground.ambilGambar(background);
        background.setIcon(homeScreenBackground);
        
        ImageIcon boxPict = Main.textBoxBackground.ambilGambar(textBoxBackground);
        textBoxBackground.setIcon(boxPict);
        
        textBoxBackground.setVisible(false);
        boxNama.setVisible(false);
        
        boxNama.setOpaque(false);
        boxNama.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        boxNama.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        teksTittle = new posisi(labelTittle);
        btnStart = new posisi(buttonStart);
        btnQuit = new posisi(buttonQuit);
        btnSetting = new posisi(buttonSetting);
        
        aturPosisiKomponen();
    }
    
    private void aturPosisiKomponen() {
        
        labelTittle.setLocation(0, 100);
        teksTittle.tengahHorizontal(this);
        
        buttonStart.setLocation(0, 500);
        btnStart.tengahHorizontal(this);
        
        buttonSetting.setLocation(0, 570);
        btnSetting.tengahHorizontal(this);
        
        buttonQuit.setLocation(0, 640);
        btnQuit.tengahHorizontal(this);
        
        boxNama.setLocation(0, 540);
        textFieldNama.tengahHorizontal(this);
        
        textBoxBackground.setLocation(0, 500);
        backgroundTFNama.tengahHorizontal(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        panelUtama2 = new javax.swing.JPanel();
        panelHomeScreen = new javax.swing.JPanel();
        buttonQuit = new javax.swing.JButton();
        buttonStart = new javax.swing.JButton();
        buttonSetting = new javax.swing.JButton();
        boxNama = new javax.swing.JTextField();
        textBoxBackground = new javax.swing.JLabel();
        labelTittle = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panelInputNamaScreen = new javax.swing.JPanel();
        panelSettingScreen = new javax.swing.JPanel();

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
        panelUtama.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUtama2.setLayout(new java.awt.CardLayout());

        panelHomeScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonQuit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonQuit.setText("Quit");
        buttonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitActionPerformed(evt);
            }
        });
        panelHomeScreen.add(buttonQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 140, 70));

        buttonStart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        panelHomeScreen.add(buttonStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 140, 70));

        buttonSetting.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonSetting.setText("Setting");
        buttonSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSettingActionPerformed(evt);
            }
        });
        panelHomeScreen.add(buttonSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 140, 70));

        boxNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        boxNama.setHighlighter(null);
        boxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNamaActionPerformed(evt);
            }
        });
        panelHomeScreen.add(boxNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 480, 80));
        panelHomeScreen.add(textBoxBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 560, 170));

        labelTittle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTittle.setText("ini tittle");
        panelHomeScreen.add(labelTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/tangga.jpg"))); // NOI18N
        panelHomeScreen.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Start");
        panelHomeScreen.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 267, 140, 70));

        panelUtama2.add(panelHomeScreen, "card2");
        panelUtama2.add(panelInputNamaScreen, "card3");
        panelUtama2.add(panelSettingScreen, "card4");

        panelUtama.add(panelUtama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        getContentPane().add(panelUtama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        aturPosisiKomponen();
    }//GEN-LAST:event_formWindowOpened

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        
        // 1. Sembunyikan tombol-tombol yang tidak diperlukan dulu
        buttonQuit.setVisible(false);
        buttonSetting.setVisible(false);
        buttonStart.setVisible(false);
    
        // 2. Tampilkan textfield nama beserta background-nya
        textBoxBackground.setVisible(true);
        boxNama.setVisible(true);
    
        // 3. BARU ATUR ULANG POSISINYA (Taruh paling bawah)
        aturPosisiKomponen();
        
        labelTittle.setLocation(0, 100);
        teksTittle.tengahHorizontal(this);
    
        // 4. Paksa Swing untuk menggambar ulang koordinat baru secara instan
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitActionPerformed
        
        if (JOptionPane.showConfirmDialog(this, "Konfrmasi jika Anda ingin keluar", "Tic-Tac-Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0); // Keluar dari program
        }
        else {
            aturPosisiKomponen();
        }
    }//GEN-LAST:event_buttonQuitActionPerformed

    private void buttonSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSettingActionPerformed

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
            java.util.logging.Logger.getLogger(inputNamaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputNamaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputNamaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputNamaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new inputNamaScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField boxNama;
    private javax.swing.JButton buttonQuit;
    private javax.swing.JButton buttonSetting;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel labelTittle;
    private javax.swing.JPanel panelHomeScreen;
    private javax.swing.JPanel panelInputNamaScreen;
    private javax.swing.JPanel panelSettingScreen;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JPanel panelUtama2;
    private javax.swing.JLabel textBoxBackground;
    // End of variables declaration//GEN-END:variables
}
