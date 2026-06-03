
package scene.ThemeScreen;

import script.posisi;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;

public class theme extends javax.swing.JFrame {
    
    private posisi judul;
    private posisi temaCampus;
    private posisi temaCastle;
    private posisi temaOrientExpress;
    private posisi tombolOpsi;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(theme.class.getName());
    private String temaTerpilih = "";
    
    public theme() {
        initComponents();
        
        setExtendedState(theme.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
        
        judul = new posisi(labelJudul);
        temaCampus = new posisi(panelCampus);
        temaCastle = new posisi(panelCastle);
        temaOrientExpress = new posisi(panelOrientExpress);
        tombolOpsi = new posisi(tombolPilihTema);
        
        
        
        ImageIcon themeScreenBackground = Global.backroundThemeScene.ambilGambar(labelBackground);
        labelBackground.setIcon(themeScreenBackground);
        tombolPilihTema.setContentAreaFilled(false);
        tombolPilihTema.setBorderPainted(false);
        tombolPilihTema.setFocusPainted(false);

        aturPosisi();
    
    }
    
    private void aturPosisi() {
        
        judul.posisi(650, 100);
        
        temaCampus.posisi(755, 400);
        
        temaCastle.posisi(550, 400);
        temaOrientExpress.posisi(960, 400);
        
        tombolOpsi.posisi(800, 700);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tombolPilihTema = new javax.swing.JButton();
        panelCampus = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCastle = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelOrientExpress = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelJudul = new javax.swing.JLabel();
        labelBackground = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tombolPilihTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/—Pngtree—start button with gradient and_5426089 (2).png"))); // NOI18N
        tombolPilihTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tombolPilihTemaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tombolPilihTemaMouseExited(evt);
            }
        });
        tombolPilihTema.addActionListener(this::tombolPilihTemaActionPerformed);
        getContentPane().add(tombolPilihTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 80, 50));

        panelCampus.setBackground(new java.awt.Color(29, 38, 64));
        panelCampus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelCampus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCampusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelCampusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelCampusMouseExited(evt);
            }
        });
        panelCampus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("==CAMPUS==");
        jLabel3.setToolTipText("");
        panelCampus.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/kampus.jpeg"))); // NOI18N
        panelCampus.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        getContentPane().add(panelCampus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 180, 240));

        panelCastle.setBackground(new java.awt.Color(29, 38, 64));
        panelCastle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelCastle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCastleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelCastleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelCastleMouseExited(evt);
            }
        });
        panelCastle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("==CASTLE==");
        jLabel5.setToolTipText("");
        panelCastle.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/Sunset Castle.jpeg"))); // NOI18N
        panelCastle.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        getContentPane().add(panelCastle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 180, 240));

        panelOrientExpress.setBackground(new java.awt.Color(29, 38, 64));
        panelOrientExpress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 112, 128), 2));
        panelOrientExpress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOrientExpressMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelOrientExpressMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOrientExpressMouseExited(evt);
            }
        });
        panelOrientExpress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/orient express.jpeg"))); // NOI18N
        panelOrientExpress.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 190));

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("==ORIENT EXPRESS==");
        jLabel7.setToolTipText("");
        panelOrientExpress.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, 30));

        getContentPane().add(panelOrientExpress, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 180, 240));

        labelJudul.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(255, 255, 255));
        labelJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJudul.setText("The Crown'Shadow");
        getContentPane().add(labelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 400, 80));

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/Fantasy Medieval Castle Wallpaper 4K.jpeg"))); // NOI18N
        labelBackground.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(labelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelCampusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCampusMouseClicked
        
        JOptionPane.showMessageDialog(this, "Tema terkunci", "The Crown'Shadow", JOptionPane.INFORMATION_MESSAGE);
        
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
        panelCastle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelOrientExpress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
                
    }//GEN-LAST:event_panelCampusMouseClicked

    private void panelCastleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCastleMouseClicked
        
        temaTerpilih = "CASTLE";
        
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelCastle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
        panelOrientExpress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        
        
    }//GEN-LAST:event_panelCastleMouseClicked

    private void panelOrientExpressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOrientExpressMouseClicked
        
        JOptionPane.showMessageDialog(this, "Tema terkunci", "The Crown'Shadow", JOptionPane.INFORMATION_MESSAGE);
        
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelCastle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        panelOrientExpress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelOrientExpressMouseClicked

    private void panelCampusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCampusMouseEntered
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelCampusMouseEntered

    private void panelCampusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCampusMouseExited
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
        
        if (!temaTerpilih.equals("CAMPUS")) {
            panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        }
    }//GEN-LAST:event_panelCampusMouseExited

    private void panelCastleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCastleMouseEntered
        // TODO add your handling code here:
        panelCastle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelCastleMouseEntered

    private void panelCastleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCastleMouseExited
        // TODO add your handling code here:
        panelCastle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
        
        if (!temaTerpilih.equals("CASTLE")) {
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
    }
    }//GEN-LAST:event_panelCastleMouseExited

    private void panelOrientExpressMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOrientExpressMouseEntered
        // TODO add your handling code here:
        panelOrientExpress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3));
    }//GEN-LAST:event_panelOrientExpressMouseEntered

    private void panelOrientExpressMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOrientExpressMouseExited
        // TODO add your handling code here:
        panelOrientExpress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
        
        if (!temaTerpilih.equals("ORIENT EXPRESS")) {
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
    }
    }//GEN-LAST:event_panelOrientExpressMouseExited

    private void tombolPilihTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolPilihTemaActionPerformed
        
        if (temaTerpilih == null || temaTerpilih.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Silakan pilih salah satu tema terlebih dahulu!", "The Crown'Shadow", javax.swing.JOptionPane.WARNING_MESSAGE);
        } 
        else {
            script.Transisi.pindahScene(this, new scene.ThemeScreen.briefingScrene());
        }
    }//GEN-LAST:event_tombolPilihTemaActionPerformed

    private void tombolPilihTemaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolPilihTemaMouseEntered
        // TODO add your handling code here:
        tombolPilihTema.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
    }//GEN-LAST:event_tombolPilihTemaMouseEntered

    private void tombolPilihTemaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolPilihTemaMouseExited
        // TODO add your handling code here:
        tombolPilihTema.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 50, 80), 1));
        
        if (!temaTerpilih.equals("CASTLE")) {
        panelCampus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 112, 128), 2));
        
    }//GEN-LAST:event_tombolPilihTemaMouseExited
    }
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new theme().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JPanel panelCampus;
    private javax.swing.JPanel panelCastle;
    private javax.swing.JPanel panelOrientExpress;
    private javax.swing.JButton tombolPilihTema;
    // End of variables declaration//GEN-END:variables
}
