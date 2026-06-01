package gamethemeselector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JFrame utama pemilihan tema game.
 * File ini pasangan dari ThemeSelectionFrame.form (GUI Designer NetBeans).
 *
 * ================================================================
 * CATATAN PENTING UNTUK NETBEANS:
 * - Buka file ini di NetBeans, klik tab "Design" untuk edit layout
 * - Blok bertanda //GEN-BEGIN dan //GEN-END jangan diubah manual
 * - Tulis logikamu di luar blok GEN tersebut
 * ================================================================
 */
public class ThemeSelectionFrame extends javax.swing.JFrame {

    // ==================== STATE PEMILIHAN ====================
    private JPanel selectedCard = null;   // Kartu yang sedang terpilih

    // ==================== CONSTRUCTOR ====================
    public ThemeSelectionFrame() {
        initComponents();
        setLocationRelativeTo(null);      // Tampil di tengah layar
        setupCardListeners();             // Pasang klik listener ke setiap kartu
        setupButtonHover();               // Efek hover tombol START
    }

    // ================================================================
    // KODE OTOMATIS NETBEANS GUI BUILDER — JANGAN EDIT MANUAL
    // (Di NetBeans asli, blok ini di-generate oleh tab Design)
    // ================================================================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        lblTitle        = new javax.swing.JLabel();
        lblSubtitle     = new javax.swing.JLabel();
        lblSelectedInfo = new javax.swing.JLabel();
        btnStart        = new javax.swing.JButton();

        // ---------- Kartu Kampus ----------
        cardKampus      = new javax.swing.JPanel();
        imgKampus       = new javax.swing.JLabel();
        lblNamaKampus   = new javax.swing.JLabel();
        lblDescKampus   = new javax.swing.JLabel();

        // ---------- Kartu Orient Express ----------
        cardOrient      = new javax.swing.JPanel();
        imgOrient       = new javax.swing.JLabel();
        lblNamaOrient   = new javax.swing.JLabel();
        lblDescOrient   = new javax.swing.JLabel();

        // ---------- Kartu Castle ----------
        cardCastle      = new javax.swing.JPanel();
        imgCastle       = new javax.swing.JLabel();
        lblNamaCastle   = new javax.swing.JLabel();
        lblDescCastle   = new javax.swing.JLabel();

        // ===== SETUP FRAME =====
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pilih Tema Game");
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(700, 480));

        // ===== BACKGROUND PANEL =====
        backgroundPanel.setBackground(new java.awt.Color(19, 28, 48));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(700, 480));
        backgroundPanel.setLayout(null);

        // ===== JUDUL =====
        lblTitle.setFont(new java.awt.Font("SansSerif", Font.BOLD, 28));
        lblTitle.setForeground(new java.awt.Color(220, 230, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PILIH TEMA");
        backgroundPanel.add(lblTitle);
        lblTitle.setBounds(0, 24, 700, 44);

        // ===== SUBJUDUL =====
        lblSubtitle.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 13));
        lblSubtitle.setForeground(new java.awt.Color(150, 165, 200));
        lblSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitle.setText("Pilih salah satu tema untuk memulai petualanganmu");
        backgroundPanel.add(lblSubtitle);
        lblSubtitle.setBounds(0, 68, 700, 22);

        // ===== KARTU KAMPUS =====
        setupCard(cardKampus, imgKampus, lblNamaKampus, lblDescKampus,
                  "Kampus", "Petualangan di kampus", 68);

        // ===== KARTU ORIENT EXPRESS =====
        setupCard(cardOrient, imgOrient, lblNamaOrient, lblDescOrient,
                  "Orient Express", "Misteri di kereta mewah", 265);

        // ===== KARTU CASTLE =====
        setupCard(cardCastle, imgCastle, lblNamaCastle, lblDescCastle,
                  "Castle", "Jelajahi kastil rahasia", 462);

        // ===== INFO TEMA TERPILIH =====
        lblSelectedInfo.setFont(new java.awt.Font("SansSerif", Font.ITALIC, 13));
        lblSelectedInfo.setForeground(new java.awt.Color(150, 165, 200));
        lblSelectedInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectedInfo.setText("Pilih tema di atas terlebih dahulu");
        backgroundPanel.add(lblSelectedInfo);
        lblSelectedInfo.setBounds(0, 368, 700, 24);

        // ===== TOMBOL START =====
        btnStart.setBackground(new java.awt.Color(60, 120, 220));
        btnStart.setFont(new java.awt.Font("SansSerif", Font.BOLD, 16));
        btnStart.setForeground(java.awt.Color.WHITE);
        btnStart.setText("START");
        btnStart.setEnabled(false);
        btnStart.setFocusPainted(false);
        btnStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnStart);
        btnStart.setBounds(210, 400, 280, 46);

        // ===== FRAME LAYOUT =====
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                          700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                          480, Short.MAX_VALUE)
        );
        pack();
    }

    // ================================================================
    // HELPER: Setup satu kartu (panel + foto + nama + deskripsi)
    // ================================================================
    private void setupCard(JPanel card, JLabel img, JLabel nama, JLabel desc,
                           String namaText, String descText, int posX) {

        card.setBackground(new java.awt.Color(38, 42, 68));
        card.setBorder(javax.swing.BorderFactory.createLineBorder(
                       new java.awt.Color(80, 100, 180), 2, true));
        card.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        card.setLayout(null);

        // --- Area foto ---
        img.setBackground(new java.awt.Color(55, 60, 90));
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setForeground(new java.awt.Color(140, 150, 190));
        img.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 11));
        img.setOpaque(true);
        img.setText("[ Tambah Foto ]");
        card.add(img);
        img.setBounds(8, 8, 154, 170);

        // --- Nama tema ---
        nama.setFont(new java.awt.Font("SansSerif", Font.BOLD, 14));
        nama.setForeground(new java.awt.Color(220, 230, 255));
        nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama.setText(namaText);
        card.add(nama);
        nama.setBounds(0, 186, 170, 24);

        // --- Deskripsi ---
        desc.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 11));
        desc.setForeground(new java.awt.Color(150, 165, 200));
        desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc.setText(descText);
        card.add(desc);
        desc.setBounds(0, 210, 170, 20);

        backgroundPanel.add(card);
        card.setBounds(posX, 108, 170, 240);
    }

    // ================================================================
    // LOGIKAMU — BOLEH EDIT BEBAS DI BAWAH INI
    // ================================================================

    /**
     * Pasang listener klik ke setiap kartu.
     * Dipanggil sekali dari constructor setelah initComponents().
     */
    private void setupCardListeners() {
        addCardClickListener(cardKampus,  imgKampus,  "Kampus",         "Petualangan di kampus");
        addCardClickListener(cardOrient,  imgOrient,  "Orient Express", "Misteri di kereta mewah");
        addCardClickListener(cardCastle,  imgCastle,  "Castle",         "Jelajahi kastil rahasia");
    }

    private void addCardClickListener(JPanel card, JLabel img, String nama, String desc) {
        // Klik di mana saja pada kartu = pilih tema
        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onCardSelected(card, nama, desc);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if (card != selectedCard) {
                    card.setBackground(new Color(50, 56, 88));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (card != selectedCard) {
                    card.setBackground(new Color(38, 42, 68));
                }
            }
        };

        // Daftarkan ke panel kartu dan semua anaknya
        card.addMouseListener(listener);
        for (Component c : card.getComponents()) {
            c.addMouseListener(listener);
        }
    }

    /** Dipanggil saat kartu diklik — update highlight & label info */
    private void onCardSelected(JPanel card, String nama, String desc) {
        // Reset warna semua kartu
        resetAllCards();

        // Highlight kartu terpilih
        card.setBackground(new Color(50, 80, 150));
        card.setBorder(BorderFactory.createLineBorder(new Color(100, 170, 255), 3, true));
        selectedCard = card;

        // Update label info
        lblSelectedInfo.setText("Tema dipilih: " + nama + " — " + desc);
        lblSelectedInfo.setForeground(new Color(100, 220, 130));

        // Aktifkan tombol START
        btnStart.setEnabled(true);
        btnStart.setBackground(new Color(60, 120, 220));
    }

    private void resetAllCards() {
        for (JPanel card : new JPanel[]{cardKampus, cardOrient, cardCastle}) {
            card.setBackground(new Color(38, 42, 68));
            card.setBorder(BorderFactory.createLineBorder(new Color(80, 100, 180), 2, true));
        }
    }

    private void setupButtonHover() {
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btnStart.isEnabled())
                    btnStart.setBackground(new Color(80, 150, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btnStart.isEnabled())
                    btnStart.setBackground(new Color(60, 120, 220));
            }
        });
    }

    // ================================================================
    // CARA GANTI FOTO KARTU:
    //
    // 1. Simpan gambarmu di: src/gamethemeselector/images/
    //    Contoh: kampus.jpg, orient.jpg, castle.jpg
    //
    // 2. Panggil setFotoKartu() dari constructor, setelah setupCardListeners()
    //    Contoh:
    //      setFotoKartu(imgKampus,  "/gamethemeselector/images/kampus.jpg");
    //      setFotoKartu(imgOrient,  "/gamethemeselector/images/orient.jpg");
    //      setFotoKartu(imgCastle,  "/gamethemeselector/images/castle.jpg");
    // ================================================================
    public void setFotoKartu(JLabel imgLabel, String resourcePath) {
        try {
            java.net.URL url = getClass().getResource(resourcePath);
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                // Resize otomatis supaya pas di kotak 154x170
                Image scaled = icon.getImage().getScaledInstance(154, 170, Image.SCALE_SMOOTH);
                imgLabel.setIcon(new ImageIcon(scaled));
                imgLabel.setText("");  // Hapus teks placeholder
            } else {
                System.out.println("Foto tidak ditemukan: " + resourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================================================================
    // EVENT HANDLER TOMBOL START — EDIT AKSI DI SINI
    // ================================================================
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        String temaTerpilih = lblSelectedInfo.getText().replace("Tema dipilih: ", "");

        // Ganti baris di bawah ini dengan buka frame game-mu:
        // GameFrame gameFrame = new GameFrame(temaTerpilih);
        // gameFrame.setVisible(true);
        // this.dispose();

        JOptionPane.showMessageDialog(this,
            "Memulai game!\n" + temaTerpilih,
            "Game Dimulai",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // ================================================================
    // FIELD KOMPONEN — Di NetBeans, bagian ini ada di dalam blok GEN
    // ================================================================
    private javax.swing.JPanel  backgroundPanel;
    private javax.swing.JLabel  lblTitle;
    private javax.swing.JLabel  lblSubtitle;
    private javax.swing.JLabel  lblSelectedInfo;
    private javax.swing.JButton btnStart;

    private javax.swing.JPanel  cardKampus;
    private javax.swing.JLabel  imgKampus;
    private javax.swing.JLabel  lblNamaKampus;
    private javax.swing.JLabel  lblDescKampus;

    private javax.swing.JPanel  cardOrient;
    private javax.swing.JLabel  imgOrient;
    private javax.swing.JLabel  lblNamaOrient;
    private javax.swing.JLabel  lblDescOrient;

    private javax.swing.JPanel  cardCastle;
    private javax.swing.JLabel  imgCastle;
    private javax.swing.JLabel  lblNamaCastle;
    private javax.swing.JLabel  lblDescCastle;
}
