
package scene.environment.temaCastle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;
import script.posisi;

public class kamarRajaScene extends javax.swing.JFrame {
    
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
    
    private boolean cekSurat = false;
    private boolean cekJejakKaki = false;
    private boolean cekBunga = false;
    private boolean cekWine = false;
    private boolean cekKertas = false;
    private boolean cekCincin = false;
    private boolean cekLilin = false;
    private boolean cekLukisan = false;
    
    private boolean apakahLagiDialog = false;
    private String[] antrianTeksMC;   
    private int indeksHalamanMC = 0;   
    
    private int opsi = 0;
    private boolean modeDialogRahasia = false; 

    public kamarRajaScene() {
        
        this.setUndecorated(true);
        
        initComponents();
        Global.initCeritaGame(); 
        setExtendedState(kamarRajaScene.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);

        ImageIcon backgroundKamarRaja = Global.backgroundKamarRajaScene.ambilGambar(background);
        background.setIcon(backgroundKamarRaja);
        
        boxDialog.setEditable(false);         
        boxDialog.setHighlighter(null);       
        boxDialog.setFocusable(false);        
        boxDialog.setCursor(null);            
        boxDialog.setBackground(new java.awt.Color(0, 0, 0, 0)); 
        
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
    
        boxDialog.setSize(800, 250);       
        
        ImageIcon detektif = main.Global.guwe.ambilGambar(detektifSprite);
        detektifSprite.setIcon(detektif);
        
        ImageIcon vesper = main.Global.Vesper.ambilGambar(vesperSprite);
        vesperSprite.setIcon(vesper);
        
        ImageIcon matthias = main.Global.Matthias.ambilGambar(matthiasSprite);
        matthiasSprite.setIcon(matthias);
        
        posisiMC = new script.posisi(detektifSprite);
        posisiBackgroundDialog = new script.posisi(backgroundDialog);
        posisiBoxDialog = new script.posisi(boxDialog);
        posisiVesper = new posisi(vesperSprite);
        posisiLabelNama = new posisi(labelNama);
        posisiButton1 = new posisi(button1);
        posisiButton2 = new posisi(button2);
        posisiButton3 = new posisi(button3);
        posisiMatthias = new posisi(matthiasSprite);
        
        matthiasSprite.setVisible(false); 
        detektifSprite.setVisible(false);
        vesperSprite.setVisible(false);
        boxDialog.setVisible(false);
        labelNama.setVisible(false);
        backgroundDialog.setVisible(false);
        
        matikanButton();
        
        posisiMC.kiriBawah(this); 
        posisiVesper.kananBawah(this);
        
        aturPosisi(); 
            
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                    melanjutkanDialogAtauTutup();
                }
            }
        });
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    
    private void matikanButton() {
        
        btnJejakKaki.setContentAreaFilled(false);
        btnJejakKaki.setBorderPainted(false);
        btnJejakKaki.setFocusPainted(false);
        btnJejakKaki.setOpaque(false);
        btnJejakKaki.setFocusable(false);
        
        btnKertas.setContentAreaFilled(false);
        btnKertas.setBorderPainted(false);
        btnKertas.setFocusPainted(false);
        btnKertas.setOpaque(false);
        btnKertas.setFocusable(false); 
        
        btnSurat.setContentAreaFilled(false);
        btnSurat.setBorderPainted(false);
        btnSurat.setFocusPainted(false);
        btnSurat.setOpaque(false);
        btnSurat.setFocusable(false); 
        
        btnLukisan.setContentAreaFilled(false);
        btnLukisan.setBorderPainted(false);
        btnLukisan.setFocusPainted(false);
        btnLukisan.setOpaque(false);
        btnLukisan.setFocusable(false); 
        
        btnWine.setContentAreaFilled(false);
        btnWine.setBorderPainted(false);
        btnWine.setFocusPainted(false);
        btnWine.setOpaque(false);
        btnWine.setFocusable(false);
        
        btnCincin.setContentAreaFilled(false);
        btnCincin.setBorderPainted(false);
        btnCincin.setFocusPainted(false);
        btnCincin.setOpaque(false);
        btnCincin.setFocusable(false);
        
        btnLilin.setContentAreaFilled(false);
        btnLilin.setBorderPainted(false);
        btnLilin.setFocusPainted(false);
        btnLilin.setOpaque(false);
        btnLilin.setFocusable(false); 
        
        btnBunga.setContentAreaFilled(false);
        btnBunga.setBorderPainted(false);
        btnBunga.setFocusPainted(false);
        btnBunga.setOpaque(false);
        btnBunga.setFocusable(false); 
        
        btnSurat.setName("Surat");
        btnLilin.setName("Lilin");
        btnWine.setName("Wine");
        btnJejakKaki.setName("JejakSepatu"); 
        btnBunga.setName("Bunga");
        btnKertas.setName("Kertas");
        btnCincin.setName("Cincin");
        btnLukisan.setName("Lukisan");
  
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
  
    
    private void munculkanDialogMC(String[] kumpulanTeks) {
        apakahLagiDialog = true;
        modeDialogRahasia = false; 
        indeksHalamanMC = 0;       
        antrianTeksMC = kumpulanTeks; 
        
        boxDialog.setVisible(true);
        detektifSprite.setVisible(true);
        labelNama.setVisible(true);
        backgroundDialog.setVisible(true);
        
        labelNama.setText(main.Global.guwe.getNamaPlayer()); 
        boxDialog.setText(antrianTeksMC[indeksHalamanMC]);
        
        this.requestFocusInWindow();
   
    }
    
    private void melanjutkanDialogAtauTutup() {
        if (!apakahLagiDialog) return;

        indeksHalamanMC++;

        if (modeDialogRahasia) {
            if (indeksHalamanMC < main.Global.dialogMatthiasChapter1Rahasia.length) {
                script.Dialog d = main.Global.dialogMatthiasChapter1Rahasia[indeksHalamanMC];

                // Atur nama pembicara
                if (d.getNama().equals("")) {
                    labelNama.setText("???");
                } else {
                    labelNama.setText(d.getNama());
                }

                if (d.getNama().equalsIgnoreCase(main.Global.Matthias.getNama())) {
                    matthiasSprite.setVisible(true);  
                } else if (d.getNama().equals("")) {
                    matthiasSprite.setVisible(false); 
                }

                boxDialog.setText(d.getTeks());

            } 
            else {
                boxDialog.setVisible(false);
                detektifSprite.setVisible(false);
                matthiasSprite.setVisible(false);
                labelNama.setVisible(false);
                backgroundDialog.setVisible(false);
                apakahLagiDialog = false;
                modeDialogRahasia = false;

                tampilkanInfoClueRahasia();

                main.Global.chapter2 = true;
                main.Global.hari = 2;
                script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarScene());
                Global.modeBebas = true;

                Global.energi = 7;

            }
            return; 
        }
        if (indeksHalamanMC < antrianTeksMC.length) {
            boxDialog.setText(antrianTeksMC[indeksHalamanMC]);
        } else {
            boxDialog.setVisible(false);
            detektifSprite.setVisible(false);
            labelNama.setVisible(false);
            backgroundDialog.setVisible(false);
            apakahLagiDialog = false;
            this.requestFocusInWindow();

            if (main.Global.energi <= 0) {
                matikanButton();

                if (main.Global.opsiCeritaKamarVesper == 3) {
                    modeDialogRahasia = true;
                    apakahLagiDialog = true;
                    indeksHalamanMC = 0;

                    boxDialog.setVisible(true);
                    detektifSprite.setVisible(true);
                    vesperSprite.setVisible(false);
                    labelNama.setVisible(true);
                    backgroundDialog.setVisible(true);

                    script.Dialog dPertama = main.Global.dialogMatthiasChapter1Rahasia[0];

                    if (dPertama.getNama().equals("")) {
                        labelNama.setText("???");
                    } else {
                        labelNama.setText(dPertama.getNama());
                    }

                    matthiasSprite.setVisible(false); 

                    boxDialog.setText(dPertama.getTeks());
                    this.requestFocusInWindow();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Kesadaranmu mulai kabur... Kamu terlalu lelah untuk melanjutkan penyelidikan malam ini.", 
                        "Kelelahan Ekstrem",
                        JOptionPane.ERROR_MESSAGE);
                    main.Global.chapter2 = true;
                    main.Global.hari = 2;
                    Global.modeBebas = true;

                Global.energi = 7;
                    script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarScene());
                }
            }
        }
    }
    
    private void tampilkanInfoClueRahasia() {

        main.Global.poinClue += 5; 

        String pesanClue = "[KESAKSIAN RAHASIA MATTHIAS DICATAT]\n\n"
                         + "Petunjuk Baru Berhasil Diungkap:\n"
                         + "\"Matthias mengaku melihat seseorang yang sangat mirip\n"
                         + "Lord Vesper keluar dari koridor pribadi Raja\n"
                         + "sekitar 1,5 jam sebelum upacara dimulai.\n\n"
                         + "Karena penglihatannya buruk,\n"
                         + "ia tidak bisa memastikan identitas orang tersebut.\"\n"
                         + "--------------------------------------------------\n"
                         + "Total Poin Clue Saat Ini = " + main.Global.poinClue + " (+5 Poin)";

        Global.tuduhVesper = true;

        JOptionPane.showMessageDialog(this, pesanClue, "Bukti Kesaksian", JOptionPane.INFORMATION_MESSAGE);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNama = new javax.swing.JLabel();
        boxDialog = new javax.swing.JTextArea();
        backgroundDialog = new javax.swing.JLabel();
        matthiasSprite = new javax.swing.JLabel();
        detektifSprite = new javax.swing.JLabel();
        vesperSprite = new javax.swing.JLabel();
        btnJejakKaki = new javax.swing.JButton();
        btnKertas = new javax.swing.JButton();
        btnSurat = new javax.swing.JButton();
        btnLukisan = new javax.swing.JButton();
        btnCincin = new javax.swing.JButton();
        btnWine = new javax.swing.JButton();
        btnLilin = new javax.swing.JButton();
        btnBunga = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
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
        getContentPane().add(boxDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 900, 190));

        backgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/dialogueBox.png"))); // NOI18N
        getContentPane().add(backgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 820, 1000, 270));
        getContentPane().add(matthiasSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));
        getContentPane().add(detektifSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));
        getContentPane().add(vesperSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));

        btnJejakKaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJejakKakiActionPerformed(evt);
            }
        });
        getContentPane().add(btnJejakKaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 800, 180, 130));

        btnKertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKertasActionPerformed(evt);
            }
        });
        getContentPane().add(btnKertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 810, 150, 110));

        btnSurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratActionPerformed(evt);
            }
        });
        getContentPane().add(btnSurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 540, 140, 100));

        btnLukisan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLukisanActionPerformed(evt);
            }
        });
        getContentPane().add(btnLukisan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 240, 220, 150));

        btnCincin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincinActionPerformed(evt);
            }
        });
        getContentPane().add(btnCincin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 660, 100, 80));

        btnWine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWineActionPerformed(evt);
            }
        });
        getContentPane().add(btnWine, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 140, 100));

        btnLilin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLilinActionPerformed(evt);
            }
        });
        getContentPane().add(btnLilin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 140, 100));

        btnBunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBungaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBunga, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 140, 100));

        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.setText("Periksa kamar raja");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 240, 330, 40));

        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.setText("Tanya lebih jauh");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 360, 330, 40));

        button3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button3.setText("Temui Matthias");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 290, 330, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background/backgroundKamarRajaClue.png"))); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        aturPosisi();
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       melanjutkanDialogAtauTutup();
    }//GEN-LAST:event_formMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void btnJejakKakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJejakKakiActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekJejakKaki) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekJejakKaki = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Jejak sepatu\n\nHasil Penyelidikan:\n"
                     + "Jejak sepatu milik seseorang. Ukurannya besar. (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogJejak = {
            "(Jejak tanah berlumpur samar tercetak di atas karpet beludru merah yang mahal ini.)",
            "(Ukurannya luar biasa besar dan cetakan tumitnya sangat dalam. Pelaku pastilah seorang pria dengan postur tubuh tinggi, tegap, dan berbobot berat.)",
            "(Di sekitar lingkungan militer kerajaan, ukuran sepatu sebesar ini... sangat identik dengan langkah kaki milik AldricJr.)"
        };
        munculkanDialogMC(dialogJejak);

        btnJejakKaki.setEnabled(false);
    }//GEN-LAST:event_btnJejakKakiActionPerformed

    private void btnSuratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratActionPerformed
        
        if (apakahLagiDialog) return; 
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekSurat) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekSurat = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Surat raja\n\nHasil Penyelidikan:\n"
                     + "Surat raja yang segelnya telah terbuka (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogSurat = {
            "(Ini adalah surat resmi dari raja... Tapi tunggu, segel lilin kerajaan ini sudah rusak dan robek.)",
            "(Berdasarkan arsip, surat ini ditujukan khusus untuk Erian. Seseorang telah membaca isinya secara paksa sebelum surat ini sampai ke tangannya.)",
            "(Siapa yang begitu berani mencuri informasi rahasia di kediaman raja? Apakah sang pelaku ingin menjebak Erian, atau justru menyembunyikan kebenaran darinya?)"
        };
        munculkanDialogMC(dialogSurat);

        btnSurat.setEnabled(false);
    }//GEN-LAST:event_btnSuratActionPerformed

    private void btnKertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKertasActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekKertas) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekKertas = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Sobekan kertas\n\nHasil Penyelidikan:\n"
                     + "Sobekan kertas berisi rumus matematika. Orang yang memiliki ini pasti cerdas. (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogKertas = {
            "(Ada sobekan kertas kecil terselip di bawah kaki kursi kerja sang raja.)",
            "(Isinya dipenuhi coretan rumus fraktal dan perhitungan matriks matematika yang sangat rumit. Orang awam tidak akan paham maksud kertas ini.)",
            "(Ini adalah kertas riset tingkat tinggi. Pemiliknya pasti seorang jenius berotak encer... Caelan. Apa yang dia hitung di ruangan ini?)"
        };
        munculkanDialogMC(dialogKertas);

        btnKertas.setEnabled(false);
    }//GEN-LAST:event_btnKertasActionPerformed

    private void btnLukisanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLukisanActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekLukisan) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekLukisan = true;
        main.Global.poinClue += 1;
        main.Global.energi -= 1;

        String pesan = "[BENDA - TIDAK PENTING]\nObjek: Lukisan keluarga raja\n\nHasil Penyelidikan:\n"
                     + "Berisikan keluarga raja (+1 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogLukisan = {
            "(Sebuah lukisan potret besar berbingkai emas megah terpajang kokoh di dinding kamar.)",
            "(Lukisan ini menggambarkan kehangatan keluarga inti kerajaan di masa lalu. Di sana juga ada Erian, tersenyum dengan sangat tulus.)",
            "(Melihat tragedi yang terjadi malam ini... senyuman di dalam lukisan kuno ini justru terasa sangat dingin dan ironis.)"
        };
        munculkanDialogMC(dialogLukisan);

        btnLukisan.setEnabled(false);
    }//GEN-LAST:event_btnLukisanActionPerformed

    private void btnCincinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincinActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekCincin) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekCincin = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Cincin besi\n\nHasil Penyelidikan:\n"
                     + "Sebuah cincin besi. Nampak usang. (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogCincin = {
            "(Sebuah cincin logam tergeletak di celah lantai kayu. Saat kuambil... rasanya kasar dan dingin.)",
            "(Ini bukan emas, bukan pula perak. Hanya besi tua usang yang bahkan sudah mulai berkarat di bagian dalamnya.)",
            "(Sangat kontras dengan kemewahan kamar raja. Perhiasan sekasar ini hanya dipakai oleh orang dengan latar belakang pekerja keras atau luar istana... seperti Vesper.)"
        };
        munculkanDialogMC(dialogCincin);

        btnCincin.setEnabled(false);
    }//GEN-LAST:event_btnCincinActionPerformed

    private void btnWineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWineActionPerformed
       
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekWine) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekWine = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Botol Wine\n\nHasil Penyelidikan:\n"
                     + "Kandungan anggur mencurigakan di meja makan raja (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogWine = {
            "(Botol wine mewah ini adalah jenis anggur yang biasa disajikan khusus untuk menjamu Erian ketika berdiskusi dengan raja.)",
            "(Aromanya sangat manis... terlalu manis hingga menyengat hidung. Ini tidak wajar untuk ukuran anggur berkelas.)",
            "(Bisa saja ini sudah dicampur zat penenang atau racun pelumpuh saraf. Sang pelaku tahu betul kebiasaan minum di kamar ini!)"
        };
        munculkanDialogMC(dialogWine);

        btnWine.setEnabled(false);
    }//GEN-LAST:event_btnWineActionPerformed

    private void btnLilinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLilinActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekLilin) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekLilin = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Lilin\n\nHasil Penyelidikan:\n"
                     + "Terdapat pesan rahasia \"... Sudah mengetahui rencana ... Jangan percaya V .... Erian harus ...\" (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogLilin = {
            "(Lilin di sudut meja ini terlihat biasa saja... tapi sisa lelehan malamnya membeku dengan cara yang aneh.)",
            "(Tunggu... ada sesuatu yang sengaja disembunyikan di bawah wadah penampung lilin ini! Sebuah sobekan memo kecil.)",
            "('... Sudah mengetahui rencana ... Jangan percaya V .... Erian harus ...')",
            "(Jangan percaya V...? Di istana ini, inisial V hanya merujuk pada satu orang... Vesper! Informasi ini harus kusimpan baik-baik.)"
        };
        munculkanDialogMC(dialogLilin);

        btnLilin.setEnabled(false);
    }//GEN-LAST:event_btnLilinActionPerformed

    private void btnBungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBungaActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekBunga) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cekBunga = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;

        String pesan = "[BENDA - PENTING]\nObjek: Beberapa kelopak bunga mawar\n\nHasil Penyelidikan:\n"
                     + "Sepertinya dimiliki oleh orang yang romantis (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini   = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);

        String[] dialogBunga = {
            "(Beberapa lembar kelopak bunga mawar segar berceceran di dekat tirai jendela...)",
            "(Siapa yang membawa bunga segar ke kamar raja di malam seperti ini? Aromanya sangat khas, parfum mawar yang elegan.)",
            "(Hanya satu orang di lingkungan istana yang dikenal sangat eksentrik, berjiwa romantis, dan selalu membawa mawar sebagai simbol statusnya... Dorian.)"
        };
        munculkanDialogMC(dialogBunga);

        btnBunga.setEnabled(false);
    }//GEN-LAST:event_btnBungaActionPerformed

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
            java.util.logging.Logger.getLogger(kamarRajaScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kamarRajaScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kamarRajaScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kamarRajaScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new kamarRajaScene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundDialog;
    private javax.swing.JTextArea boxDialog;
    private javax.swing.JButton btnBunga;
    private javax.swing.JButton btnCincin;
    private javax.swing.JButton btnJejakKaki;
    private javax.swing.JButton btnKertas;
    private javax.swing.JButton btnLilin;
    private javax.swing.JButton btnLukisan;
    private javax.swing.JButton btnSurat;
    private javax.swing.JButton btnWine;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JLabel detektifSprite;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel matthiasSprite;
    private javax.swing.JLabel vesperSprite;
    // End of variables declaration//GEN-END:variables
}
