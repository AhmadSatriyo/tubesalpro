
package scene.environment.temaCastle;


import scene.ThemeScreen.*;
import script.posisi;
import scene.environment.temaCastle.kamarScene;

public class transisiChapter1 extends javax.swing.JFrame {

    private posisi posisiBoxText;
    private int counterTeks;
    private String teks;
    private posisi posisiButtonNext;
            
    public transisiChapter1() {
        this.setUndecorated(true);
        
        initComponents();
        setExtendedState(transisiChapter1.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
    
        counterTeks = 1;
    
        opsiTeks(counterTeks); 
        boxText.setSize(800, 250); 
        boxText.setBackground(new java.awt.Color(0, 0, 0, 0));
    
    
        posisiBoxText = new posisi(boxText);
        posisiButtonNext = new posisi(buttonNext);
        
        aturPosisi();
    
    }
    
    private void chapter1(int awal, int akhir) {
        
        
    }
    
    private void aturPosisi() {
        
        posisiBoxText.posisi(0, 300); 
        posisiBoxText.tengahHorizontal(this);
        
        posisiButtonNext.posisi(0,700);
        posisiButtonNext.tengahHorizontal(this);
        
    }
    
    private void opsiTeks(int counter) {
        
        switch (counter) {
            case 1 :
                teks = """
                       Chapter 1 — Bertemu Vesper
                       
                       Ruang Kerja Lord Vesper
                       """;
                break;
            
        }
        
        tampilkanTeks(teks);
        
    }
    
    private void tampilkanTeks(String teks) {

        boxText.setText(teks);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        boxText = new javax.swing.JTextArea();
        buttonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setForeground(new java.awt.Color(0, 0, 0));
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        background.setLayout(null);

        boxText.setEditable(false);
        boxText.setColumns(4);
        boxText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxText.setForeground(new java.awt.Color(255, 255, 255));
        boxText.setRows(5);
        boxText.setTabSize(5);
        boxText.setText("Selama empat puluh tahun, Raja Aldric memimpin Kerajaan Valdris.\n\nDi bawah pemerintahannya, kerajaan berkembang menjadi salah satu kekuatan terbesar di benua ini. \nNamun usia sang raja telah senja, dan seluruh negeri menanti satu hal:\n\nsiapa yang akan mewarisi mahkota.");
        boxText.setToolTipText("");
        boxText.setAutoscrolls(false);
        boxText.setBorder(null);
        boxText.setCaretColor(new java.awt.Color(0, 0, 0));
        boxText.setHighlighter(null);
        background.add(boxText);
        boxText.setBounds(173, 145, 874, 230);

        buttonNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        background.add(buttonNext);
        buttonNext.setBounds(680, 220, 140, 70);

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        

        if (counterTeks < 8) {
            counterTeks++;          
            opsiTeks(counterTeks);  
        } else {
            script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarVesperScene());
      
        }

    }//GEN-LAST:event_buttonNextActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        aturPosisi();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(transisiChapter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transisiChapter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transisiChapter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transisiChapter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transisiChapter1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JTextArea boxText;
    private javax.swing.JButton buttonNext;
    // End of variables declaration//GEN-END:variables
}
