package main;

import script.Dialog;
import script.Saksi;
import script.Tersangka;
import script.background;
import script.clue;
import script.detektif;

public class Global {
    
    public static int indeksDialog = 0;
    public static int hari = 1;
    public static int energi = 5;
    public static int poinClue = 0;
    
    // 1. DAFTAR BACKGROUND (Tetap boleh langsung dibuat karena tidak butuh nama player)
    public static background bgTangga = new background("/assets/background/tangga.jpg", "Latar Tangga");
    public static background homeScreenBackground = new background("/assets/background/homeScreen.png", "lobby screen");
    public static background textBoxBackground = new background("/assets/ui/input.png", "teks box input nama");
    public static background backroundThemeScene = new background("/assets/character/homeScreen.png", "background theme");
    public static background backgroundIntroScene = new background("/assets/background/castleIntro.jpeg", "background intro");
    public static background backgroundIntroScene2 = new background("/assets/background/backgroundKastil.jpg", "background kastil");
    public static background backgoundKamarScene = new background("/assets/background/backgroundKamarMC.jpg", "background kamar mc");
    public static background backgroundKamarVesperScene = new background("/assets/background/kamarVesper.jpg", "background kamar vesper");
        
    // 2. DEKLARASI KARAKTER & DIALOG (Kosongkan dulu, jangan di-'new' di sini!)
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
    
    public static boolean chapter1 = false;
    public static boolean chapter2 = false;
    public static boolean chapter3 = false;
    public static boolean chapter4 = false;
    
    //clue
    //clue chapter 1
    //clue percakapan
    public static clue clueMatthias1;
    public static clue clueMattihias2;
    
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
    // 1. Array sementara untuk menampung pangeran yang bisa dituduh
        Tersangka[] kandidat = {Dorian, Caelan, AldricJr};
    
    // 2. Buat objek Random buat mengocok indeks
        java.util.Random hoki = new java.util.Random();
    
    // 3. Ambil angka acak dari 0 sampai 2 (karena panjang array kandidat adalah 3)
        int indeksAcak = hoki.nextInt(kandidat.length);
    
    // 4. SLOT 1: Vesper selalu jadi tersangka utama, kunci di indeks 0
        tersangkaTerpilih[0] = Vesper;
        
        tersangkaTerpilih[1] = kandidat[indeksAcak];
        
        for(Tersangka namaTersangka : tersangkaTerpilih) {
            namaTersangka.setPembunuh(true);
        }
    
    // 5. TUGASMU: Masukkan pangeran dari array 'kandidat' berdasarkan 'indeksAcak' 
    //    ke dalam array 'tersangkaTerpilih' di indeks ke-1

    //    tersangkaTerpilih[1] = ... ;
    }
    
    // =========================================================================
    // SAKELAR UTAMA: Method ini wajib dipanggil setelah user input nama!
    // =========================================================================
    public static void initCeritaGame() {
        
        // A. BARU KITA BUAT OBJEK DETEKTIF DAN KARAKTER DI SINI (Nama Player dijamin ter-update!)
        guwe = new detektif("/assets/character/detektif.jpg", "detektif", namaPlayer);
        NyonyaSera = new Saksi("/assets/character/dummyNyonysSera.png", "Nyonya Sera");
        Erian = new Saksi("/assets/character/dummyErian.png", "Erian");
        Matthias = new Saksi("/assets/character/dummyMatthias.png", "Matthias");
        Dorian = new Tersangka("/assets/character/dummyDorian.png", "Dorian", "Selalu bohong");
        Caelan = new Tersangka("/assets/character/dummyCaelan.png", "Caelan", "Selalu jujur");
        AldricJr = new Tersangka("/assets/character/dummyAldricJr", "Aldric Jr.", "Kadang jujur");
        Vesper = new Tersangka("/assets/character/dummyVesper.png", "Tuan Vesper", "Kadang jujur");
        
        clueMatthias1 = new clue("Dua orang dan raja", "Matthias mendengar suara dua orang selain raja sebelum kejadian tersebut.", true, Matthias, Matthias.getNama(), 3);
        clueMattihias2 = new clue("Raja tertawa sebelum kematiannya", "Matthias mendengarkan suara raja yang tertawa kecil sebelum kematiannya", true, Matthias, Matthias.getNama(), 2);
    
        
        
        // B. BARU KITA JALANKAN ARRAY DIALOGNYA
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
            new Dialog("dummy", "Tidak ada yang benar-benar jujur."),
            new Dialog("dummy", "Empat pangeran."),
            new Dialog("dummy", "Empat calon pewaris."),
            new Dialog("dummy", "Masing-masing memiliki alasan untuk menginginkan sang raja pergi."),
            new Dialog("dummy", "Pangeran Aldric Jr."),
            new Dialog("dummy", "Putra sulung kerajaan."),
            new Dialog("dummy", "Seharusnya menjadi penerus takhta berdasarkan tradisi."),
            new Dialog("dummy", "Namun keputusan sang raja merenggut hak tersebut darinya."),
            new Dialog("Pangeran Eran", "Putra kedua dan calon raja yang dipilih langsung oleh sang ayah."),
            new Dialog("Pangeran Eran", "Dicintai rakyat karena sifatnya yang baik dan rendah hati."),
            new Dialog("Pangeran Caelan", "Putra ketiga."),
            new Dialog("Pangeran Caelan", "Dikenal sebagai orang paling cerdas di kerajaan."),
            new Dialog("Pangeran Caelan", "Pendiam, sulit ditebak, dan selalu beberapa langkah di depan orang lain."),
            new Dialog("Pangeran Dorian", "Putra bungsu."),
            new Dialog("Pangeran Dorian", "Karismatik dan populer di kalangan bangsawan."),
            new Dialog("Pangeran Dorian", "Sering dianggap tidak tertarik pada urusan politik.")
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
            new Dialog(guwe.getNamaPlayer(), "Dan kamu memanggilku karena kamu yakin kemungkinan pelakunya bukan berasal dari luar?"),
            new Dialog(Vesper.getNama(), "Hahaha, anda  memang cermat"),
            new Dialog(guwe.getNamaPlayer(), "Berarti untuk saat ini, tersangkanya adalah keempat pangeran?"),
            new Dialog(Vesper.getNama(), "Benar, saya mengerti bahwa terdapat gejolak kekuasaan di dalam internal keluarga kerajaan"),
            new Dialog(guwe.getNamaPlayer(), "Dan kau?"),
            new Dialog(Vesper.getNama(), "Aku? Aku hanya penasihat tua yang terlalu lama hidup untuk percaya pada kebetulan."),
            new Dialog(guwe.getNamaPlayer(), "Itu bukan jawaban."),
            new Dialog(Vesper.getNama(), "Kalau begitu anggap aku juga tersangka."),
            
        };
        
        dialogVesperChapter1Opsi1 = new Dialog[] {
            new Dialog(guwe.getNamaPlayer(), "Raja meniggal di kamarnya kan? Di mana kamarnya?."),
            new Dialog(guwe.getNamaPlayer(), "Aku ingin melihatnya secara langsung."),
            new Dialog(guwe.getNamaPlayer(), "Mungkin terdapat petunjuk dari kasus ini."),
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
        };
    }
}