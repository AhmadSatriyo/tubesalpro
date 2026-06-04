package script;

public class Transisi {
    
    private static boolean sedangAnimasi = false;

    public static void pindahScene(javax.swing.JFrame frameSekarang, javax.swing.JFrame frameTujuan) {

    if (sedangAnimasi) return; 
    sedangAnimasi = true;

    javax.swing.JPanel overlay = new javax.swing.JPanel() {
        private int alphaValue = 0;
        
        @Override
        protected void paintComponent(java.awt.Graphics g) {
            java.awt.Graphics2D g2d = (java.awt.Graphics2D) g.create();
            g2d.setColor(new java.awt.Color(0, 0, 0, alphaValue)); 
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
        
        public void setAlpha(int alpha) {
            this.alphaValue = alpha;
            repaint();
        }
    };

    overlay.setBounds(0, 0, frameSekarang.getWidth(), frameSekarang.getHeight());
    overlay.setOpaque(false); 

    frameSekarang.getLayeredPane().add(overlay, javax.swing.JLayeredPane.DRAG_LAYER);
    frameSekarang.getLayeredPane().revalidate();

    javax.swing.Timer timerFade = new javax.swing.Timer(10, null);
    timerFade.addActionListener(new java.awt.event.ActionListener() {
        private int alpha = 0;
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            alpha += 15; 
            
            if (alpha >= 255) {
                timerFade.stop(); 
                
                frameTujuan.setVisible(true); 
                frameSekarang.dispose();      
                sedangAnimasi = false;         
            } else {
                try {
                    overlay.getClass().getMethod("setAlpha", int.class).invoke(overlay, alpha);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });

    timerFade.start();
}
}