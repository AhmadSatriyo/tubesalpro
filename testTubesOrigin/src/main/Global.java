package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import script.Dialog;
import script.Saksi;
import script.Tersangka;
import script.background;
import script.clue;
import script.detektif;

public class Global {
    
    private static boolean sudahInit = false;
    
    public static int indeksDialog = 0;
    public static int hari = 1;
    public static int energi = 5;
    public static int poinClue = 0;
    public static boolean tuduhVesper = false;
    
    public static boolean modeBebas = false;
    
    public static int opsiCeritaKamarVesper = 0;
    
    public static Clip bgmClip;
    
    public static background homeScreenBackground = new background("/assets/background/homeScreen.png", "lobby screen");
    public static background textBoxBackground = new background("/assets/ui/input.png", "teks box input nama");
    public static background backroundThemeScene = new background("/assets/character/homeScreen.png", "background theme");
    public static background backgroundIntroScene = new background("/assets/background/backgroundAwal.png", "background intro");
    public static background backgroundIntroScene2 = new background("/assets/background/backgroundKastil.png", "background kastil");
    public static background backgoundKamarScene = new background("/assets/background/backgroundKamarMC.jpg", "background kamar mc");
    public static background backgroundKamarVesperScene = new background("/assets/background/backgroundKamarVesper.png", "background kamar vesper");
    public static background backgroundKamarRajaScene = new background("/assets/background/backgroundKamarRajaClue.png", "background kamar raja dengan clue");
    public static background backgroundPerpustakaanScene = new background("/assets/background/backgroundCaelan.png", "background perpustakaan");
    public static background backgroundPerpustakaanTersangkaScene = new background("/assets/background/backgroundCaelantersangka.png", "background perpustakaan");
    public static background backgroundPengadilanScene = new background("/assets/background/pengadilan.jpeg", "background pengadilan");
        
    public static detektif guwe;
    public static Saksi NyonyaSera;
    public static Saksi Erian;
    public static Saksi Matthias;
    public static Tersangka Dorian;
    public static Tersangka Caelan;
    public static Tersangka AldricJr;
    public static Tersangka Vesper;
   
    public static Dialog[] listBriefing;
    
    //chapter 1
    public static Dialog[] dialogVesperChapter1;
    public static Dialog[] dialogVesperChapter1Opsi1;
    public static Dialog[] dialogVesperChapter1Opsi2;
    public static Dialog[] dialogVesperChapter1Opsi3;
    public static Dialog[] dialogMatthiasChapter1Rahasia;
    
    //chapter 2 -> caelan
    public static Dialog[] dialogCaelanInteraksiBebas;
    public static Dialog[] dialogCaelanKertas;
    public static Dialog[] dialogCaelanBuku;
    public static Dialog[] dialogCaelanBotolRacun;
    
    
    //endingscene
    public static Dialog[] dialogPengadilan;
    
    public static boolean chapter1 = false;
    public static boolean chapter2 = false;
    public static boolean chapter3 = false;
    public static boolean chapter4 = false;
    
    //clue barang
    public static clue clueUtamaKamarRajaSurat;
    public static clue clueUtamaKamarRajaLilin;
    public static clue clueUtamaKamarRajaWine;
    public static clue clueUtamaAldricKamarRajaJejakSepatu;
    public static clue clueUtamaDorianKamarRajaBunga;
    public static clue clueUtamaCaelanKamarRajaKertas;
    public static clue clueUtamaVesperKamarRajaCincin;
    public static clue clueSampinganKamarRajaLukisan;
    
    public static String namaPlayer = "Dummy";    
    
    public static void main(String[] args) {
        initCeritaGame(); 
        
        new scene.HomeScreen.homeScreen().setVisible(true);
    }
    
    public static void masukanNamaPlayer(String nama) {
        Global.namaPlayer = nama;
    }
    
    public static Tersangka[] tersangkaTerpilih = new Tersangka[2];
    
    public static void acakTersangka() {
        Tersangka[] kandidat = {Dorian, Caelan, AldricJr};
    
        java.util.Random hoki = new java.util.Random();
    
        int indeksAcak = hoki.nextInt(kandidat.length);
    
        tersangkaTerpilih[0] = Vesper;
        tersangkaTerpilih[1] = kandidat[indeksAcak];
        
        for(Tersangka namaTersangka : tersangkaTerpilih) {
            System.out.println("pembunuh : " + namaTersangka.getNama());
            namaTersangka.setPembunuh(true);
        }
   
    }
    
    public static void putarMusik(String pathFileMusik) {
        if (bgmClip != null && bgmClip.isRunning()) {
            return; 
        }
        
        try {
            File fileMusik = new File(pathFileMusik);
            if (fileMusik.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(fileMusik);
                bgmClip = AudioSystem.getClip();
                bgmClip.open(audioInput);
                
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY); 
                bgmClip.start();
            } else {
                System.out.println("File musik tidak ditemukan di: " + pathFileMusik);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initCeritaGame() {
        
        if (sudahInit) {
            return; 
        }
       
        sudahInit = true;
        
        guwe = new detektif("/assets/character/detektifKael.png", "detektif", namaPlayer);
        NyonyaSera = new Saksi("/assets/character/dummyNyonysSera.png", "Nyonya Sera");
        Erian = new Saksi("/assets/character/eran.png", "Eran");
        Matthias = new Saksi("/assets/character/matthias.png", "Matthias");
        Dorian = new Tersangka("/assets/character/dorian.png", "Dorian", "Selalu bohong");
        Caelan = new Tersangka("/assets/character/caelan.png", "Caelan", "Selalu jujur");
        AldricJr = new Tersangka("/assets/character/aldric.png", "Aldric Jr.", "Kadang jujur");
        Vesper = new Tersangka("/assets/character/vesper.png", "Tuan Vesper", "Kadang jujur");
        
        acakTersangka();

                
        listBriefing = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Namaku " + guwe.getNamaPlayer()), // Ambil nama langsung dari getter detektif!
            new Dialog(guwe.getNamaPlayer(), "Mantan penjaga kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Kini seorang detektif."),
            new Dialog(guwe.getNamaPlayer(), "Tiga tahun lalu aku meninggalkan istana dan bersumpah tidak akan pernah kembali."),
            new Dialog(guwe.getNamaPlayer(), "Namun pagi ini, sebuah surat membawaku kembali ke tempat yang paling ingin kulupakan."),
            new Dialog(Vesper.getNama(), "\"Detektif " + guwe.getNamaPlayer() + "\""),
            new Dialog(Vesper.getNama(), "Raja telah tiada."),
            new Dialog(Vesper.getNama(), "\"Kerajaan membutuhkanmu.\""),
            new Dialog(Vesper.getNama(), "\"Datanglah sebelum kebenaran ikut terkubur.\""),
            new Dialog(Vesper.getNama(), "\"—" + Vesper.getNama() + "\""),
            new Dialog(guwe.getNamaPlayer(), "Ketika aku tiba di Kastil Valdris, seluruh penghuni istana tampak menyembunyikan sesuatu."),
            new Dialog(guwe.getNamaPlayer(), "Tidak ada yang benar-benar berduka."),
            new Dialog(guwe.getNamaPlayer(), "Tidak ada yang benar-benar jujur."),
            new Dialog(guwe.getNamaPlayer(), "Empat pangeran."),
            new Dialog(guwe.getNamaPlayer(), "Empat calon pewaris."),
            new Dialog(guwe.getNamaPlayer(), "Masing-masing memiliki alasan untuk menginginkan sang raja pergi."),
            new Dialog(guwe.getNamaPlayer(), "Pangeran Aldric Jr."),
            new Dialog(guwe.getNamaPlayer(), "Putra sulung kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Seharusnya menjadi penerus takhta berdasarkan tradisi."),
            new Dialog(guwe.getNamaPlayer(), "Namun keputusan sang raja merenggut hak tersebut darinya."),
            new Dialog(guwe.getNamaPlayer(), "Pangeran Eran, Putra kedua dan calon raja yang dipilih langsung oleh sang ayah."),
            new Dialog(guwe.getNamaPlayer(), "Dicintai rakyat karena sifatnya yang baik dan rendah hati."),
            new Dialog(guwe.getNamaPlayer(), "Pangeran Caelan. Putra ketiga."),
            new Dialog(guwe.getNamaPlayer(), "Dikenal sebagai orang paling cerdas di kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Pendiam, sulit ditebak, dan selalu beberapa langkah di depan orang lain."),
            new Dialog(guwe.getNamaPlayer(), "Pangeran Dorian, Putra bungsu."),
            new Dialog(guwe.getNamaPlayer(), "Karismatik dan populer di kalangan bangsawan."),
            new Dialog(guwe.getNamaPlayer(), "Sering dianggap tidak tertarik pada urusan politik.")
        };
        
        dialogVesperChapter1 = new Dialog[] {
            new Dialog(Vesper.getNama(), "Terima kasih telah datang, " + guwe.getNamaPlayer() + "."),
            new Dialog(guwe.getNamaPlayer(), "Aku datang karena seseorang mati."),
            new Dialog(Vesper.getNama(), "Dan aku berharap kau menemukan siapa pelakunya sebelum kerajaan ini ikut mati."),
            new Dialog(guwe.getNamaPlayer(), "Oh, ya? Memangnya tidak ada penerus yang cukup mampu untuk menjadi raja selanjutnya?"),
            new Dialog(Vesper.getNama(), "Beberapa pihak bangsawan dan rakyat memang lebih memilih Pangeran Aldric Jr. sebagai raja selanjutnya."),
            new Dialog(guwe.getNamaPlayer(), "Oh, kalau begitu jadikan dia raja saja. Mengapa kau repot-repot memanggilku kemari?"),
            new Dialog(Vesper.getNama(), "Tentu saja karena kasus ini tidak bisa dilupakan begitu saja."),
            new Dialog(guwe.getNamaPlayer(), "Hmm, iya kah? Aku sedang tidak ingin terlibat dalam permasalahan keluarga"),
            new Dialog(Vesper.getNama(), "Oh, ayolah, tuan " + guwe.getNama() + " . Anda memang skeptis seperti yang dibicarakan"),
            new Dialog(guwe.getNamaPlayer(), "Apapun itu, kematian sang raja cukup ganjil."),
            new Dialog(guwe.getNamaPlayer(), "Apa yang sedang kau lakukan saat kejadian tersebut terjadi?"),
            new Dialog(Vesper.getNama(), "Beberapa urusan politik."),
            new Dialog(guwe.getNamaPlayer(), "Begitukah? seberapa pentingnya hingga kau meninggalkan rajamu sendirian, wahai penasihat raja?"),
            new Dialog(Vesper.getNama(), "Raja bukanlah anak kecil yang harus ditemani setiap saat"),
            new Dialog(guwe.getNamaPlayer(), "Hmm, coba ceritakan kejadiannya sejak awal"),
            new Dialog(Vesper.getNama(), "Raja Aldric ditemukan tewas satu jam sebelum upacara penobatan."),
            new Dialog(guwe.getNamaPlayer(), "Siapa yang menemukan jasadnya?"),
            new Dialog(Vesper.getNama(), "Matthias. Pelayan tua kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Dan tersangkanya?"),
            new Dialog(Vesper.getNama(), "Untuk saat ini, pasukan tengah mencari informasi mengenai kemungkinan penghianat"),
            
        };
        
        dialogVesperChapter1Opsi1 = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Raja meniggal di kamarnya kan? Di mana kamarnya?."),
            new Dialog(guwe.getNamaPlayer(), "Aku ingin melihatnya secara langsung."),
            new Dialog(guwe.getNamaPlayer(), "Mungkin terdapat petunjuk dari kasus ini."),
            new Dialog(Vesper.getNama(), "Baik, silakan lewat sebelah sini.")
        };
        
        dialogVesperChapter1Opsi2 = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Ada satu hal yang menggangguku."),
            new Dialog(Vesper.getNama(), "Dan itu?"),
            new Dialog(guwe.getNamaPlayer(), "Kenapa kamu yang memanggilku?"),
            new Dialog(Vesper.getNama(), "Aku menduga kau akan menanyakan itu."),
            new Dialog(guwe.getNamaPlayer(), "(Terlalu cepat.)"),
            new Dialog(guwe.getNamaPlayer(), "Seolah dia sudah menyiapkan jawabannya sebelum aku masuk ruangan ini."),
            new Dialog(guwe.getNamaPlayer(), "Jadi?"),
            new Dialog(Vesper.getNama(), "Karena penjaga kerajaan tidak akan cukup."),
            new Dialog(guwe.getNamaPlayer(), "Kapten penjaga sudah menyelidiki?"),
            new Dialog(Vesper.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Dan?"),
            new Dialog(Vesper.getNama(), "Mereka sudah memiliki tersangka."),
            new Dialog(guwe.getNamaPlayer(), "(Cepat sekali.)"),
            new Dialog(guwe.getNamaPlayer(), "Siapa?"),
            new Dialog(Vesper.getNama(), tersangkaTerpilih[1].getNama()),
            new Dialog(Vesper.getNama(), "Motifnya jelas."),
            new Dialog(Vesper.getNama(), "Menurutku kasus yang terlalu mudah biasanya berbahaya."),
            new Dialog(guwe.getNamaPlayer(), "(Jawaban yang bagus.)"),
            new Dialog(guwe.getNamaPlayer(), "(Terlalu bagus.)"),
            new Dialog(guwe.getNamaPlayer(), "Kenapa tidak memanggil hakim kerajaan?"),
            new Dialog(Vesper.getNama(), "Karena hakim mencari orang untuk dihukum."),
            new Dialog(guwe.getNamaPlayer(), "Dan aku?"),
            new Dialog(Vesper.getNama(), "Kau mencari kebenaran."),
            new Dialog(guwe.getNamaPlayer(), "(Kalimat itu terdengar seperti pujian.)"),
            new Dialog(guwe.getNamaPlayer(), "(Tapi juga terdengar seperti sesuatu yang sudah dihafalkan berkali-kali.)"),
            new Dialog(guwe.getNamaPlayer(), "Kau terdengar sangat siap menghadapi pertanyaan ini."),
            new Dialog(Vesper.getNama(), "Aku sudah menjadi penasihat selama dua puluh lima tahun, Detektif."),
            new Dialog(Vesper.getNama(), "Aku belajar bahwa setiap keputusan besar akan selalu dipertanyakan"),
            new Dialog(guwe.getNamaPlayer(), "Baiklah."),
            new Dialog(guwe.getNamaPlayer(), "Raja meniggal di kamarnya kan? Di mana kamarnya?."),
            new Dialog(guwe.getNamaPlayer(), "Aku ingin melihatnya secara langsung."),
            new Dialog(guwe.getNamaPlayer(), "Mungkin terdapat petunjuk dari kasus ini."),
            new Dialog(Vesper.getNama(), "Baik, silakan lewat sebelah sini.")
        };
        
        dialogVesperChapter1Opsi3 = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Aku ingin bertemu dengan Matthias."),
            new Dialog(Vesper.getNama(), "Baiklah, aku akan memanggil Matthias."),
            new Dialog(Vesper.getNama(), "Matthias, kemarilah."),
            new Dialog(Matthias.getNama(), "Baik, tuan, saya akan segera ke sana."),
            new Dialog(Matthias.getNama(), "Ada apa, tuan?."),
            new Dialog(Vesper.getNama(), "Inilah Matthias, tuan detektif " + guwe.getNamaPlayer() + "."),
            new Dialog(Matthias.getNama(), "Perkenalkan, saya Matthias. Saya merupakan pelayan dari kerajaan ini."),
            new Dialog(guwe.getNamaPlayer(), "Oke, Matthias, aku ingin menanyaimu mengenai kejadian kematian raja."),
            new Dialog(guwe.getNamaPlayer(), "Apa yang kamu ketahui mengenai kejadian tersebut?"),
            new Dialog(Matthias.getNama(), "Saya mendengar dua suara di waktu kejadian tersebut."),
            new Dialog(guwe.getNamaPlayer(), "Dua suara?"),
            new Dialog(Matthias.getNama(), "Benar, tuan."),
            new Dialog(guwe.getNamaPlayer(), "Bagaimana dengan raja?"),
            new Dialog(Matthias.getNama(), "Saya mendengar sang raja tertawa kecil sebelum kejadian tersebut terjadi."),
            new Dialog(guwe.getNamaPlayer(), "Raja tertawa? berarti totalnya 3 orang termasuk raja?"),
            new Dialog(Matthias.getNama(), "Benar, tuan"),
            new Dialog(guwe.getNamaPlayer(), "Baik, terima kasih, Matthias. Aku akan mencatat hal ini."),
            new Dialog(Matthias.getNama(), "Baik, saya izin permsisi, tuan"),
            new Dialog(guwe.getNamaPlayer(), "Baiklah."),
            new Dialog(guwe.getNamaPlayer(), "Raja meniggal di kamarnya kan? Di mana kamarnya?."),
            new Dialog(guwe.getNamaPlayer(), "Aku ingin melihatnya secara langsung."),
            new Dialog(guwe.getNamaPlayer(), "Mungkin terdapat petunjuk dari kasus ini."),
            new Dialog(Vesper.getNama(), "Baik, silakan lewat sebelah sini.")
        };
        
        dialogMatthiasChapter1Rahasia = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Yah, aku rasa itu sudah cukup untuk hari ini."),
            new Dialog("", "Tok tok tok tok ..."),
            new Dialog(guwe.getNamaPlayer(), "Masuk."),
            new Dialog(Matthias.getNama(), "Detektif."),
            new Dialog(Matthias.getNama(), "Benar, tuan.Maaf mengganggu."),
            new Dialog(guwe.getNamaPlayer(), "Oh, ada apa, Matthias?"),
            new Dialog(guwe.getNamaPlayer(), "Ada sesuatu yang belum kau ceritakan?"),
            new Dialog(Matthias.getNama(), "Saya... tidak yakin apakah ini penting."),
            new Dialog(guwe.getNamaPlayer(), "Biarkan aku yang menentukan itu."),
            new Dialog(Matthias.getNama(), "Saya sudah tua."),
            new Dialog(Matthias.getNama(), "Mata saya tidak lagi setajam dulu."),
            new Dialog(guwe.getNamaPlayer(), "Dan justru karena mata saya sudah buruk, saya takut mengatakan ini."),
            new Dialog(guwe.getNamaPlayer(), "Mengatakan apa?"),
            new Dialog(Matthias.getNama(), "Sebelum jenazah ditemukan..."),
            new Dialog(Matthias.getNama(), "Saya melihat seseorang keluar dari koridor pribadi raja."),
            new Dialog(guwe.getNamaPlayer(), "Kapan?"),
            new Dialog(Matthias.getNama(), "Kira-kira satu setengah jam sebelum upacara."),
            new Dialog(guwe.getNamaPlayer(), "Kau mengenalinya?"),
            new Dialog(Matthias.getNama(), "Tidak sepenuhnya."),
            new Dialog(Matthias.getNama(), "Koridor itu remang-remang."),
            new Dialog(guwe.getNamaPlayer(), "Tapi?"),
            new Dialog(Matthias.getNama(), "Sosoknya..."),
            new Dialog(Matthias.getNama(), "Mirip seseorang."),
            new Dialog(guwe.getNamaPlayer(), "Siapa?"),
            new Dialog(Matthias.getNama(), "Tuan Vesper."),
            new Dialog(guwe.getNamaPlayer(), "Mirip Tuan Vesper?"),
            new Dialog(Matthias.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Mirip atau memang dia?"),
            new Dialog(Matthias.getNama(), "Saya tidak berani bersumpah."),
            new Dialog(Matthias.getNama(), "Terlalu jauh. Terlalu gelap."),
            new Dialog(guwe.getNamaPlayer(), "Kenapa baru memberitahuku sekarang?"),
            new Dialog(Matthias.getNama(), "Karena kalau saya salah... Saya baru saja menuduh penasihat kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Dan kalau kau benar?"),
            new Dialog(Matthias.getNama(), "Maka saya mungkin orang berikutnya yang ditemukan mati di kastil ini."),
            new Dialog(guwe.getNamaPlayer(), "(Ketakutan itu terdengar nyata. Terlalu nyata untuk dipalsukan.)"),
            new Dialog(guwe.getNamaPlayer(), "Apa lagi yang kau ingat?"),
            new Dialog(Matthias.getNama(), "Tidak banyak."),
            new Dialog(Matthias.getNama(), "Orang itu berjalan cepat. Seolah tidak ingin dilihat."),
            new Dialog(guwe.getNamaPlayer(), "Jadi kau yakin soal waktunya?"),
            new Dialog(Matthias.getNama(), "Sangat yakin."),
            new Dialog(guwe.getNamaPlayer(), "(Satu setengah jam sebelum kematian.)"),
            new Dialog(guwe.getNamaPlayer(), "(Dekat dengan waktu kejadian.)"),
            new Dialog(guwe.getNamaPlayer(), "(Terlalu dekat untuk diabaikan.)"),
            new Dialog(guwe.getNamaPlayer(), "Baiklah, terima kasih, Matthias. Aku akan mencari tau lebih banyak"),
        };
        
        dialogCaelanInteraksiBebas = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Kau masih membaca?"),
            new Dialog(Caelan.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Ayahmu baru saja meninggal."),
            new Dialog(Caelan.getNama(), "Fakta yang sudah aku ketahui."),
            new Dialog(guwe.getNamaPlayer(), "Dan itu tidak mengganggumu?"),
            new Dialog(Caelan.getNama(), "Tentu menggangguku."),
            new Dialog(Caelan.getNama(), "Tetapi kesedihan tidak akan menghidupkannya kembali."),
            new Dialog(Caelan.getNama(), "Jadi aku memilih menggunakan waktuku untuk memahami apa yang terjadi."),      
        };
        
        dialogCaelanKertas = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Aku menemukan sobekan kertas ini di kamar raja."),
            new Dialog(guwe.getNamaPlayer(), "Tulisan ini milikmu?"),
            new Dialog(Caelan.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Rumus apa ini?"),
            new Dialog(Caelan.getNama(), "Model prediksi hasil panen kerajaan."),
            new Dialog(guwe.getNamaPlayer(), "Kedengarannya tidak berhubungan dengan pembunuhan."),
            new Dialog(Caelan.getNama(), "Karena memang tidak berhubungan."),
            new Dialog(guwe.getNamaPlayer(), "Jadi kenapa ada di kamar raja?"),
            new Dialog(Caelan.getNama(), "Ayah memintaku menjelaskan laporan ekonomi seminggu lalu."),
            new Dialog(Caelan.getNama(), "Kemungkinan kertas itu tertinggal."),
            new Dialog(guwe.getNamaPlayer(), "(Jawaban masuk akal.)"),
        };
        
        dialogCaelanBuku = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Aku menemukan buku toksikologi ini."),
            new Dialog(guwe.getNamaPlayer(), "Halaman tentang racun tanpa warna dan tanpa rasa ditandai"),
            new Dialog(Caelan.getNama(), "Benar."),
            new Dialog(guwe.getNamaPlayer(), "Kau tidak mencoba menyangkal?"),
            new Dialog(Caelan.getNama(), "Mengapa aku harus menyangkal sesuatu yang memang benar?"),
            new Dialog(guwe.getNamaPlayer(), "Jadi kau mempelajari racun."),
            new Dialog(Caelan.getNama(), "Detektif."),
            new Dialog(Caelan.getNama(), "Halaman berikutnya membahas penawar racun yang sama."),
            new Dialog(Caelan.getNama(), "Apakah kau membacanya?"),
            new Dialog(guwe.getNamaPlayer(), "..."),
            new Dialog(Caelan.getNama(), "Orang sering berhenti membaca ketika mereka menemukan sesuatu yang ingin mereka percaya."),
            new Dialog(guwe.getNamaPlayer(), "(Menyebalkan.)"),
            new Dialog(guwe.getNamaPlayer(), "(Tapi dia tidak salah.)"),
        };
        
        dialogCaelanBotolRacun = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Aku menemukan ini di laci terkuncimu."),
            new Dialog(guwe.getNamaPlayer(), "Botol racun."),
            new Dialog(Caelan.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Jadi itu milikmu."),
            new Dialog(Caelan.getNama(), "Ya."),
            new Dialog(guwe.getNamaPlayer(), "Racun yang sama dengan yang ditemukan dalam anggur raja."),
            new Dialog(Caelan.getNama(), "Kemungkinan besar."),
            new Dialog(guwe.getNamaPlayer(), "Kau tidak menyangkal sedikit pun?"),
            new Dialog(Caelan.getNama(), "Menyangkal tidak akan mengubah isi botol itu."),
            new Dialog(guwe.getNamaPlayer(), "Lalu apa penjelasanmu?"),
            new Dialog(Caelan.getNama(), "Penjelasan dan alasan adalah dua hal berbeda."),
            new Dialog(Caelan.getNama(), "Aku bisa menjelaskan mengapa botol itu ada di kamarku."),
            new Dialog(guwe.getNamaPlayer(), "Coba saja."),
            new Dialog(Caelan.getNama(), "Aku memang menyimpan racun itu."),
            new Dialog(Caelan.getNama(), "Untuk penelitian."),
            new Dialog(Caelan.getNama(), "Fakta itu benar."),
            new Dialog(Caelan.getNama(), "Pertanyaannya adalah:"),
            new Dialog(Caelan.getNama(), "Apakah aku menggunakannya untuk membunuh ayah?"),
            new Dialog(guwe.getNamaPlayer(), "Untuk pertama kalinya..."),
            new Dialog(guwe.getNamaPlayer(), "bahkan aku tidak tahu apakah dia sedang membela diri..."),
            new Dialog(guwe.getNamaPlayer(), "atau sedang mempersiapkan pengakuan."),
        };
        dialogPengadilan = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Ini saatnya. Aku harus menentukan siapa pelakunya."),
            new Dialog(guwe.getNamaPlayer(), "Semua bukti yang aku kumpulkan... semuanya mengarah ke satu orang."),
            new Dialog(Caelan.getNama(), "Detektif. Apapun kesimpulanmu, aku harap kau benar-benar yakin."),
            new Dialog(Dorian.getNama(), "Jangan salah langkah. Kerajaan ini tidak memberi ruang untuk kesalahan."),
            new Dialog(AldricJr.getNama(), "Aku tidak melakukan apapun. Ingat itu."),
            new Dialog(guwe.getNamaPlayer(), "Siapa yang membunuh Raja Aldric?"),
            new Dialog(guwe.getNamaPlayer(), "Aku sudah memutuskan."),
};
    }
}