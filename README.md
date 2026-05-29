# tubesalpro

branch:
1. main -> untuk yang udah bener-bener fix
2. prototype -> tempat merge sebelum ke main
3. mahesWorks -> punya mahesa
4. satriyo -> punya satriyo
5. zahra -> punya zahra

jadi push ke breanch masing-masing, cek sama tesing dulu, baru merge ke prototype, terus baru ke main

To-Do:
1. bikin readme yang proper beserta syntax GitHub (done)
2. bikin penjelasan masing-masing package dan class (not yet)
3. bikin plan sederhana cara kerja/alur game dengan ngehubungin tiap class (Zahra for the flowchart and im going to somehow connect it to the code)
4. bikin plan tampilan ui (mahesa dan aku)
5. bkin plan asset, music, dll (all)
6. bikin pembagian tugas pakai sprint (not yet)

flowchart of how its going to look like
semua tombol yang perlu input (kayak pemilihan tema gaboleh bisa dipencet sebelum user milih)

area homeScren / pre-game
1. homeScreen
   start -> continue next scene (not yet -> Satriyo)
   setting -> settingScene -> music, save?, resetProgress?, checkCharacter?
   quit -> showoptiondialog untuk konfirm mau keluar
2. inputNamaScreen -> habis klik start, lanjut ke sini, user input nama ke textBoxField dan disimpan ke global untuk dipakai di sepanjang game
   start -> masuk pemilihan tema
   quit/retutrn -> balik  ke homeScreen
3. themeScreen -> user bakal milih salah satu tema dengan cara klik sekali. opsional tambahin fitur cancel piliahn
   return -> balik ke inputNamaSccreen

gameIntro
1. intro sederhana pakai black screen dengan diberi teks menceritakan secara singkat mengenai kasus yang akan dihadapi
2. buku atau kertas berisi tersangka dan sifat

gameFR


bikin:

* beberapa halaman GUI
* sistem perpindahan scene
* dialog
* clue
* timer
* pengecekan ending
  
Misalnya:
Tema Kampus.

# 3. BAGI TUGAS KE TIM

# ANGGOTA 1 — GUI & Frontend : Mahesa

Tugas:

* bikin tampilan Java Swing
* button
* panel
* perpindahan halaman
* gambar background
* timer display

Yang dipelajari:

* JFrame
* JPanel
* CardLayout
* JButton
* JLabel
* ImageIcon

---

# ANGGOTA 2 — GAME LOGIC : Satriyo

Tugas:

* sistem clue
* random pembunuh
* sistem kejujuran
* ending
* score
* timer logic
* data character

Yang dipelajari:

* OOP Java
* ArrayList
* Random
* class object
* if else
* state management

---

# GAME DESIGN : Zahra

Tugas:

* menyusun alur game
* menulis cerita
* membuat data karakter
* membuat data clue
* membuat dialog
* membuat/mencari asset 

---

# 4. HAL YANG HARUS DISIAPKAN

# A. CERITA

WAJIB.

Minimal:

* siapa korban
* siapa pembunuh
* motif
* alibi tiap karakter
* clue benar
* clue palsu

Contoh:

Korban:
Professor Webb

Pembunuh:
Marcus

Motif:
Marcus ketahuan mencuri data penelitian

Alibi:
“Aku di asrama”

Clue:

* sidik jari di lab
* CCTV mati
* gelas kopi

---

# B. FLOW GAME

Sudah bagus di dokumenmu.

Sekarang ubah jadi:

## daftar scene

Contoh:

1. Home
2. Pilih Tema
3. Intro
4. Lobby
5. Lokasi
6. Interogasi
7. Clue
8. Tuduhan
9. Ending

Ini nanti jadi class GUI.

---

# C. DATA KARAKTER

Buat tabel.

Contoh:

| Nama   | Role      | Jujur? | Motif |
| ------ | --------- | ------ | ----- |
| Marcus | Tersangka | Bohong | Ada   |
| Evelyn | Saksi     | Jujur  | Tidak |
| Lena   | Tersangka | Kadang | Ada   |

---

# D. DATA CLUE

Contoh:

| Lokasi | Clue          | Benar? |
| ------ | ------------- | ------ |
| Lab    | Sidik jari    | Ya     |
| Kantin | Gelas kopi    | Ya     |
| Perpus | Surat ancaman | Palsu  |

```text
src/
│
├── main/
│   └── Main.java
│
├── gui/
│   ├── HomeScreen.java
│   ├── ThemeScreen.java
│   ├── LobbyScreen.java
│   ├── InvestigationScreen.java
│   └── EndingScreen.java
│
├── model/
│   ├── Character.java
│   ├── Clue.java
│   ├── Location.java
│   └── GameData.java
│
├── logic/
│   ├── GameManager.java
│   ├── EndingManager.java
│   └── Randomizer.java
│
├── assets/
│   ├── images/
│   ├── music/
│   └── fonts/
```
# 9. TARGET REALISTIS UNTUK 2–3 MINGGU

Kalau aku jadi pembimbingmu:

## Minggu 1

* desain game
* cerita
* GUI dasar
* struktur project

## Minggu 2

* gameplay
* clue
* ending
* randomisasi

## Minggu 3

* polishing
* bug fixing
* presentasi

## CardLayout

Ini cocok banget untuk visual novel/game GUI.

Karena tiap halaman jadi “card”.

Misalnya:

* homeCard
* lobbyCard
* endingCard

tinggal switch.

