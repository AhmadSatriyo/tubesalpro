# tubesalpro

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

