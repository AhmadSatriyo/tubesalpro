# tubesalpro

1. rancang sistem dulu
2. bagi tugas
3. tentukan scope
4. baru coding sedikit demi sedikit

bikin:

* beberapa halaman GUI
* sistem perpindahan scene
* dialog
* clue
* timer
* pengecekan ending

Buat:

# “Blueprint Project”

## A. Scope awal (WAJIB)

# MVP (Minimum Viable Product)

## Gunakan:

* 1 tema saja
* 4 lokasi
* 3 tersangka
* 1 saksi
* 1 korban
* 1 ending benar
* 1 ending salah

Misalnya:
Tema Kampus.

# 3. BAGI TUGAS KE TIM

# ANGGOTA 1 — GUI & Frontend

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

# ANGGOTA 2 — GAME LOGIC

Tugas:

* sistem clue
* random pembunuh
* sistem kejujuran
* ending
* score
* timer logic

Yang dipelajari:

* OOP Java
* ArrayList
* Random
* class object
* if else
* state management

---

# GAME DESIGN + INTEGRATOR

Tugas:

* menyusun alur game
* menulis cerita
* membuat data karakter
* menyatukan coding anggota
* debugging
* testing
* presentasi

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

---

# E. ASSET GAMBAR

Kalian perlu:

* background
* karakter
* icon
* tombol

TAPI:
untuk tugas kuliah,
jangan terlalu ambisius.

Gunakan:

* AI image
* Pinterest
* free assets

Yang penting konsisten.

---

# F. MUSIK & SOUND

Optional tapi bagus.

Minimal:

* background music misteri
* tombol klik
* true ending sound
* wrong ending sound

Cari:

* Pixabay
* Freesound
* OpenGameArt

---

# G. FONT

Kadang bikin visual jauh lebih bagus.

Gunakan font:

* Cinzel (misteri)
* Playfair
* Poppins

---

# 5. TEKNOLOGI YANG AKAN DIPAKAI

Aku sarankan:

# Java Swing

Karena:

* paling mudah
* cocok tugas kuliah
* GUI cepat dibuat

Jangan JavaFX kalau kalian masih bingung.

---

# 6. STRUKTUR PROJECT YANG BENAR

Ini penting banget.

Project kalian nanti kira-kira:

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

---

# 7. URUTAN DEVELOPMENT YANG BENAR

INI BAGIAN PALING PENTING.

Jangan random coding.

Urutan benar:

# STEP 1 — Buat GUI Kosong Dulu

Target:
semua halaman bisa pindah.

Belum ada gameplay.

Misalnya:
Home → Tema → Lobby → Ending

SELESAI DULU.

---

# STEP 2 — Tambahkan Data Karakter

Buat:

* class Character
* class Clue

Isi dummy dulu.

---

# STEP 3 — Tambahkan Sistem Lokasi

Klik lokasi:
muncul clue.

---

# STEP 4 — Tambahkan Interogasi

Klik karakter:
muncul dialog.

---

# STEP 5 — Tambahkan Random Pembunuh

Saat game start:
pilih pembunuh random.

---

# STEP 6 — Tambahkan Ending

Pilih tersangka:
cek benar/salah.

---

# STEP 7 — Tambahkan Timer

Baru timer paling akhir.

Karena timer sering bikin bug.

---

# STEP 8 — Polishing

* gambar
* musik
* animasi kecil
* transisi

---

# 8. HAL YANG PALING SERING BIKIN PROJECT GAGAL

## A. Scope terlalu besar

Langsung bikin:

* 3 tema
* 10 ending
* AI
* save system

Akhirnya gak selesai.

---

## B. Tidak ada pembagian tugas jelas

Akhirnya:
1 orang kerja
2 orang hilang.

---

## C. Tidak ada integrasi rutin

Solusi:
setiap 2 hari:
gabungkan coding.

Jangan nunggu akhir.

---

## D. Tidak pakai Git/GitHub

PAKAI GITHUB.

WAJIB.

Minimal:

* backup
* merge file
* pembagian kerja aman

---

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

---

# 10. YANG HARUS KAMU LAKUKAN BESOK

Ini checklist nyata.

## BESOK:

### 1. Meeting tim

Bahas:

* tema pertama
* siapa mengerjakan apa

---

### 2. Buat folder project

---

### 3. Buat struktur class

---

### 4. Buat flow halaman

---

### 5. Buat cerita lengkap SATU kasus

---

### 6. Buat GUI Home Screen dulu

Jangan yang lain.

---

# 11. REKOMENDASI PALING PENTING DARIKU

Jangan fokus:

> “game harus keren”

Fokus:

> “game harus selesai dan stabil”

Dosen biasanya lebih suka:

* alur jelas
* OOP rapi
* GUI jalan
* fitur lengkap

daripada:

* visual keren
* tapi bug semua

---

# 12. Saran Tambahan yang Sangat Membantu

Gunakan:

## CardLayout

Ini cocok banget untuk visual novel/game GUI.

Karena tiap halaman jadi “card”.

Misalnya:

* homeCard
* lobbyCard
* endingCard

tinggal switch.

Ini jauh lebih mudah daripada buka banyak JFrame.

---

# 13. Hal yang Menurutku Sebaiknya Jangan Kalian Tambahkan Dulu

Jangan dulu:

* database
* multiplayer
* save/load
* networking
* voice acting
* AI NPC

Itu terlalu besar untuk tugas GUI Java biasa.

---

Kalau kamu mau, setelah ini aku bisa bantu lagi dengan:

* struktur class OOP lengkap
* contoh pembagian folder project
* roadmap mingguan detail
* desain database/data game
* diagram class UML
* cara membuat GUI Java Swing
* contoh alur coding per halaman
* cara random pembunuh
* cara sistem clue bekerja
* cara integrasi semua anggota
* cara presentasi tugas besar

Dan menurutku langkah terbaik setelah ini adalah:

## aku bantu kamu membuat “arsitektur project” dulu supaya kalian bertiga tidak coding ngawur.
