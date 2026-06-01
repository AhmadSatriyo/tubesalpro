package script; // Sesuaikan dengan nama package Transisi kamu

public class Transisi {
    
    // Variabel kunci biar timer gak bisa diduplikasi saat di-klik barbar
    private static boolean sedangAnimasi = false;

    public static void pindahScene(javax.swing.JFrame frameSekarang, javax.swing.JFrame frameTujuan) {
    // Jika sedang ada animasi berjalan, abaikan klik tombol berikutnya (Anti-Spam)
    if (sedangAnimasi) return; 
    sedangAnimasi = true;

    // 1. Buat custom panel hitam penutup
    javax.swing.JPanel overlay = new javax.swing.JPanel() {
        private int alphaValue = 0;
        
        @Override
        protected void paintComponent(java.awt.Graphics g) {
            java.awt.Graphics2D g2d = (java.awt.Graphics2D) g.create();
            g2d.setColor(new java.awt.Color(0, 0, 0, alphaValue)); // HITAM MURNI
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
        
        // Method custom untuk mengubah nilai alpha
        public void setAlpha(int alpha) {
            this.alphaValue = alpha;
            repaint();
        }
    };

    // Atur ukuran overlay mengikuti resolusi Frame saat ini
    overlay.setBounds(0, 0, frameSekarang.getWidth(), frameSekarang.getHeight());
    overlay.setOpaque(false); 

    // 2. Tempelkan ke layer terdepan
    frameSekarang.getLayeredPane().add(overlay, javax.swing.JLayeredPane.DRAG_LAYER);
    frameSekarang.getLayeredPane().revalidate();

    // 3. Jalankan Timer Animasi (Setiap 10 milidetik)
    javax.swing.Timer timerFade = new javax.swing.Timer(10, null);
    timerFade.addActionListener(new java.awt.event.ActionListener() {
        private int alpha = 0;
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            alpha += 15; // Kecepatan menggelap (bisa dinaikkan biar makin cepat)
            
            if (alpha >= 255) {
                timerFade.stop(); // Berhenti kalau sudah hitam pekat
                
                frameTujuan.setVisible(true); // Buka form baru
                frameSekarang.dispose();       // Hancurkan form lama
                sedangAnimasi = false;         // Reset kunci anti-spam
            } else {
                // Panggil method setAlpha() di dalam overlay menggunakan Reflection Java
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