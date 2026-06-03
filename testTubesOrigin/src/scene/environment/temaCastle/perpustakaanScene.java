package scene.environment.temaCastle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Global;
import script.posisi;
/**
 *
 * @author ryo
 */
public class perpustakaanScene extends javax.swing.JFrame {
    
    private posisi posisiBackgroundDialog;
    private posisi posisiMC;
    private posisi posisiCaelan;
    private posisi posisiBoxDialog;
    private String teks;
    private posisi posisiLabelNama;
    private posisi posisiButton1;
    private posisi posisiButton2;
    private posisi posisiButton3;
    private posisi posisiButton4;
    private posisi posisiButtonKembaliDariDialog;
    private posisi posisiButtonKembaliKeKamar;
    
    private script.Dialog[] antrianDialogCabang;
    
    private boolean modeDialogCabang = false;
    private boolean cekBuku;
    private boolean cekBotolRacun;
    
    private boolean apakahLagiDialog = false;
    private String[] antrianTeksMC;  
    private int indeksHalamanMC = 0;   
    
    private int opsi = 0;
    private boolean modeDialogRahasia = false; 

    public perpustakaanScene() {
        this.setUndecorated(true);
        
        initComponents();
        Global.initCeritaGame(); 
        setExtendedState(perpustakaanScene.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(null);
        
        ImageIcon backgroundKamarCaelan = Global.backgoundKamarScene.ambilGambar(background);
        
        if(Global.tersangkaTerpilih[1].getNama().equals(Global.Caelan.getNama())) {
            backgroundKamarCaelan = Global.backgroundPerpustakaanTersangkaScene.ambilGambar(background);
        }
        else {
            backgroundKamarCaelan = Global.backgroundPerpustakaanScene.ambilGambar(background);
        }
        
        background.setIcon(backgroundKamarCaelan);

        boxDialog.setEditable(false);        
        boxDialog.setHighlighter(null);      
        boxDialog.setFocusable(false);        
        boxDialog.setCursor(null);            
        boxDialog.setBackground(new java.awt.Color(0, 0, 0, 0)); 
        
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        buttonKembaliDariDialog.setVisible(false); 
    
        boxDialog.setSize(800, 250);          
        
        ImageIcon detektif = main.Global.guwe.ambilGambar(detektifSprite);
        detektifSprite.setIcon(detektif);
        
        ImageIcon caelan = main.Global.Caelan.ambilGambar(caelanSprite);
        caelanSprite.setIcon(caelan);
        
        posisiMC = new script.posisi(detektifSprite);
        posisiCaelan = new script.posisi(caelanSprite);
        posisiBackgroundDialog = new script.posisi(backgroundDialog);
        posisiBoxDialog = new script.posisi(boxDialog);
        posisiLabelNama = new posisi(labelNama);
        posisiButton1 = new posisi(button1);
        posisiButton2 = new posisi(button2);
        posisiButton3 = new posisi(button3);
        posisiButton4 = new posisi(button4);
        posisiButtonKembaliDariDialog = new posisi(buttonKembaliDariDialog);
        posisiButtonKembaliKeKamar = new posisi(buttonKembaliKeKamar);

        detektifSprite.setVisible(false);
        caelanSprite.setVisible(true);
        boxDialog.setVisible(false);
        labelNama.setVisible(false);
        backgroundDialog.setVisible(false); 
        
        matikanButton();
        
        posisiMC.kiriBawah(this); 
        posisiCaelan.kananBawah(this);
        
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
        
        button1.setFocusable(true);
        button2.setFocusable(true);
        button3.setFocusable(true);
        button4.setFocusable(true);
        buttonKembaliDariDialog.setFocusable(true);
    }
    
    
    private void matikanButton() {
        
        btnBuku.setContentAreaFilled(false);
        btnBuku.setBorderPainted(false);
        btnBuku.setFocusPainted(false);
        btnBuku.setOpaque(false);
        btnBuku.setFocusable(false); 
        
        btnRacun.setContentAreaFilled(false);
        btnRacun.setBorderPainted(false);
        btnRacun.setFocusPainted(false);
        btnRacun.setOpaque(false);
        btnRacun.setFocusable(false); 
        
        btnBuku.setName("BukuRacun"); 
        btnRacun.setName("BotolRacun");
  
    }
  
    
    private void aturPosisi() {
        posisiMC.posisi(0, 200);
        posisiMC.kiriBawah(this);
        
        posisiCaelan.posisi(0, 200);
        posisiCaelan.kananBawah(this);
        
        posisiBackgroundDialog.aturSebagaiBackgroundDialog(this);
        
        posisiBoxDialog.aturSebagaiBoxDialog(this);
        
        posisiLabelNama.aturSebagaiLabelNama();
        
        posisiButton1.posisi(0, 250); 
        posisiButton1.tengahHorizontal(this);
        posisiButton2.posisi(0, 310); 
        posisiButton2.tengahHorizontal(this);
        posisiButton3.posisi(0, 370); 
        posisiButton3.tengahHorizontal(this);
        posisiButton4.posisi(0, 430); 
        posisiButton4.tengahHorizontal(this);
        posisiButtonKembaliDariDialog.posisi(0, 490);
        posisiButtonKembaliDariDialog.tengahHorizontal(this);
        
        buttonKembaliKeKamar.setLocation(20, 20);
        
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
        
        if (modeDialogCabang) {
            if (indeksHalamanMC < antrianDialogCabang.length) {
                script.Dialog d = antrianDialogCabang[indeksHalamanMC];
                
                labelNama.setText(d.getNama().equals("") ? "???" : d.getNama());
                boxDialog.setText(d.getTeks());
                
                if (d.getNama().equalsIgnoreCase(main.Global.Caelan.getNama())) {
                    caelanSprite.setVisible(true);
                }
            } else {
                boxDialog.setVisible(false);
                detektifSprite.setVisible(false);
                labelNama.setVisible(false);
                backgroundDialog.setVisible(false);
                apakahLagiDialog = false;
                modeDialogCabang = false;
                this.requestFocusInWindow();
            }
            return;
        }


        if (modeDialogRahasia) {
            if (indeksHalamanMC < main.Global.dialogMatthiasChapter1Rahasia.length) {
                script.Dialog d = main.Global.dialogMatthiasChapter1Rahasia[indeksHalamanMC];
                labelNama.setText(d.getNama().equals("") ? "???" : d.getNama());
                if (d.getNama().equalsIgnoreCase(main.Global.Caelan.getNama())) {
                    caelanSprite.setVisible(true); 
                } else if (d.getNama().equals("")) {
                    caelanSprite.setVisible(false);
                }
                boxDialog.setText(d.getTeks());
            } else {
                boxDialog.setVisible(false);
                detektifSprite.setVisible(false);
                caelanSprite.setVisible(false);
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
                   
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Kesadaranmu mulai kabur... Kamu terlalu lelah untuk melanjutkan penyelidikan malam ini.", 
                        "Kelelahan Ekstrem", JOptionPane.ERROR_MESSAGE);
                    main.Global.chapter2 = true;
                    main.Global.hari = 2;
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

        JOptionPane.showMessageDialog(this, pesanClue, "Bukti Kesaksian", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mulaiDialogPercabangan(script.Dialog[] skripTerpilih) {
        bersihkanMenuOpsi(); 
    
        buttonKembaliDariDialog.setVisible(false); 

        apakahLagiDialog = true;
        modeDialogCabang = true;
        indeksHalamanMC = 0;
        antrianDialogCabang = skripTerpilih;

        detektifSprite.setVisible(true);

        // Muat halaman pertama percakapan
        script.Dialog dataPertama = antrianDialogCabang[indeksHalamanMC];
        labelNama.setText(dataPertama.getNama().equals("") ? "???" : dataPertama.getNama());
        boxDialog.setText(dataPertama.getTeks());
        this.requestFocusInWindow();
    }
    
    private void bersihkanMenuOpsi() {
        
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        buttonKembaliKeKamar.setVisible(true); 
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
        detektifSprite = new javax.swing.JLabel();
        caelanSprite = new javax.swing.JLabel();
        btnBuku = new javax.swing.JButton();
        btnRacun = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        buttonKembaliDariDialog = new javax.swing.JButton();
        buttonKembaliKeKamar = new javax.swing.JButton();
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
        getContentPane().add(detektifSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));

        caelanSprite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caelanSpriteMouseClicked(evt);
            }
        });
        getContentPane().add(caelanSprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 350, 80, 120));

        btnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukuActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 800, 180, 130));

        btnRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRacunActionPerformed(evt);
            }
        });
        getContentPane().add(btnRacun, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 810, 150, 110));

        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.setText("Interaksi bebas");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 240, 330, 40));

        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.setText("Sobekan kertas");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 300, 330, 40));

        button3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button3.setText("Buku riset racun");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 360, 330, 40));

        button4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button4.setText("Botol racun");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 420, 330, 40));

        buttonKembaliDariDialog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonKembaliDariDialog.setText("Kembali");
        buttonKembaliDariDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliDariDialogActionPerformed(evt);
            }
        });
        getContentPane().add(buttonKembaliDariDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 480, 330, 40));

        buttonKembaliKeKamar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonKembaliKeKamar.setText("Kembali ke kamar");
        buttonKembaliKeKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliKeKamarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonKembaliKeKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 640, 330, 40));

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
        main.Global.energi -= 1; // Potong energi di sini
    this.setFocusable(true);  // Kembalikan fokus ke frame untuk Spacebar
    mulaiDialogPercabangan(main.Global.dialogCaelanInteraksiBebas);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        main.Global.energi -= 1; // Potong energi di sini
    this.setFocusable(true);  
    mulaiDialogPercabangan(main.Global.dialogCaelanKertas);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        main.Global.energi -= 1; // Potong energi di sini
    this.setFocusable(true);  
    mulaiDialogPercabangan(main.Global.dialogCaelanBuku);
    }//GEN-LAST:event_button3ActionPerformed

    private void btnBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukuActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekBuku) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        cekBuku = true;
        main.Global.poinClue += 3;
        main.Global.energi -= 1;
        
        String pesan = "[BUKTI - BUKU POISON]\nObjek: Buku Toksikologi Kerajaan\n\nHasil Penyelidikan:\n"
                     + "Buku milik Caelan mengenai racun dan penawarnya. (+3 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini    = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Ditemukan", JOptionPane.INFORMATION_MESSAGE);
        
        String[] dialogBukuLokal = {
            "(Sebuah buku tua bersampul kulit tebal tergeletak di meja belajar Caelan.)",
            "(Judulnya 'Studi Toksikologi Komparatif'. Ini adalah buku medis tingkat tinggi yang membahas racun-racun mematikan...)"
        };
        munculkanDialogMC(dialogBukuLokal);
        btnBuku.setEnabled(false);
    }//GEN-LAST:event_btnBukuActionPerformed

    private void btnRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRacunActionPerformed
        
        if (apakahLagiDialog) return;
        if (main.Global.energi <= 0) {
            JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk menyelidiki.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cekBotolRacun) {
            JOptionPane.showMessageDialog(this, "Kamu sudah memeriksa objek ini sebelumnya.", "Investigasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        cekBotolRacun = true;
        main.Global.poinClue += 5; // Bukti kunci pembunuh otomatis dapat poin lebih tinggi
        main.Global.energi -= 1;
        
        String pesan = "[BUKTI KUNCI - RACUN]\nObjek: Botol Cairan Gelap\n\nHasil Penyelidikan:\n"
                     + "Botol berisi racun murni yang disembunyikan di dalam laci terkunci. (+5 Poin)\n"
                     + "--------------------------------------------------\n"
                     + "Poin saat ini    = " + main.Global.poinClue + "\n"
                     + "Energi saat ini = " + main.Global.energi;
        JOptionPane.showMessageDialog(this, pesan, "Petunjuk Vital Ditemukan", JOptionPane.INFORMATION_MESSAGE);
        
        String[] dialogRacunLokal = {
            "(Aku berhasil mencongkel laci rahasia di sudut lemari pakaian Caelan.)",
            "(Di dalamnya terdapat sebuah botol kaca kecil tak berlabel berisi sisa cairan bening berbau aneh...)"
        };
        munculkanDialogMC(dialogRacunLokal);
        btnRacun.setEnabled(false);
    }//GEN-LAST:event_btnRacunActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        main.Global.energi -= 1; // Potong energi di sini
    this.setFocusable(true);  
    mulaiDialogPercabangan(main.Global.dialogCaelanBotolRacun);
    }//GEN-LAST:event_button4ActionPerformed

    private void caelanSpriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caelanSpriteMouseClicked
        if (apakahLagiDialog || modeDialogCabang || button1.isVisible()) return;

    if (main.Global.energi <= 0) {
        JOptionPane.showMessageDialog(this, "Kamu terlalu lelah untuk berbicara dengan siapa pun saat ini.", "Energi Habis", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // PENTING: Pengurangan energi DIHAPUS dari sini, dipindah ke tombol aksi!
    apakahLagiDialog = false;
    modeDialogCabang = false;
    
    boxDialog.setText("");
    boxDialog.setVisible(true);
    backgroundDialog.setVisible(true);
    detektifSprite.setVisible(false);
    caelanSprite.setVisible(true);
    labelNama.setVisible(true);
    labelNama.setText("Pilih Topik Interogasi:");

    buttonKembaliKeKamar.setVisible(false);

    // Aktifkan tombol menu pertanyaan
    button1.setVisible(true);

    button2.setVisible(true);

    if (cekBuku) {
        button3.setVisible(true);
    } else {
        button3.setVisible(false);
    }

    if (cekBotolRacun) {
        button4.setVisible(true);
    } else {
        button4.setVisible(false);
    }
    
    buttonKembaliDariDialog.setVisible(true); 
    
    // Memastikan frame tidak mencuri fokus mouse dari tombol
    this.setFocusable(false);
    }//GEN-LAST:event_caelanSpriteMouseClicked

    private void buttonKembaliDariDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliDariDialogActionPerformed
        button1.setVisible(false);
    button2.setVisible(false);
    button3.setVisible(false);
    button4.setVisible(false);
    
    // 2. Sembunyikan tombol 'Kembali' ini sendiri
    buttonKembaliDariDialog.setVisible(false);
    
    // 3. Bersihkan dan sembunyikan komponen GUI dialog
    boxDialog.setText("");
    boxDialog.setVisible(false);
    backgroundDialog.setVisible(false);
    labelNama.setVisible(false);
    
    // 4. Munculkan kembali tombol navigasi utama map untuk kembali ke kamar induk
    buttonKembaliKeKamar.setVisible(true); 
    
    // 5. Kembalikan fokus ke Frame utama agar input Spacebar/Keyboard tidak macet
    this.setFocusable(true); 
    this.requestFocusInWindow();
    }//GEN-LAST:event_buttonKembaliDariDialogActionPerformed

    private void buttonKembaliKeKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliKeKamarActionPerformed
        if (apakahLagiDialog || modeDialogCabang) return;
        
        // Pindah scene kembali ke kamar induk peta tanpa pengurangan energi
        script.Transisi.pindahScene(this, new scene.environment.temaCastle.kamarScene());
    }//GEN-LAST:event_buttonKembaliKeKamarActionPerformed

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
            java.util.logging.Logger.getLogger(perpustakaanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perpustakaanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perpustakaanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perpustakaanScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new perpustakaanScene().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundDialog;
    private javax.swing.JTextArea boxDialog;
    private javax.swing.JButton btnBuku;
    private javax.swing.JButton btnRacun;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton buttonKembaliDariDialog;
    private javax.swing.JButton buttonKembaliKeKamar;
    private javax.swing.JLabel caelanSprite;
    private javax.swing.JLabel detektifSprite;
    private javax.swing.JLabel labelNama;
    // End of variables declaration//GEN-END:variables
}
