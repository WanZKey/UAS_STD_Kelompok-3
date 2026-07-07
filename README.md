# Proyek Akhir (UAS) Struktur Data - Kelompok 3

Repositori ini berisi keseluruhan source code, laporan, dan dokumen presentasi untuk memenuhi Tugas Proyek Akhir (UAS) pada mata kuliah Struktur Data.

**Judul Proyek:**
`SIMULASI PENERAPAN STRUKTUR DATA QUEUE DAN ALGORITMA SEQUENTIAL SEARCHING PADA SISTEM MANAJEMEN OPERASIONAL KANTIN BERBASIS KOTLIN`

**Dosen Pengampu:** Putri Armilia Prayesy, M.Kom.

### Daftar Anggota Kelompok

| No | Nama               | NIM     |
| -- | ------------------ | ------- |
| 1  | Radisa Arisandi    | 1062581 |
| 2  | Riduan             | 1062584 |
| 3  | Viona Diva Shifana | 1062589 |

---

## Deskripsi Tugas

Proyek ini dibuat berdasarkan instruksi tugas UAS berikut:

> "Buatlah sebuah aplikasi berbasis Kotlin, studi kasus mengenai materi yang telah dipelajari. Aplikasi yang dibuat harus mampu menyelesaikan suatu permasalahan nyata dan menunjukkan penggunaan struktur data serta menjelaskan cara kerja algoritma yang digunakan beserta analisis kompleksitas waktunya."

**Output Proyek yang harus dipenuhi:**

1. Source code program
2. Laporan analisis
3. Presentasi/demo aplikasi

---

## Overview Proyek & Studi Kasus

Proyek yang kami buat mengangkat studi kasus program manajemen antrean kantin kampus. Aplikasi berbasis Console (CLI) ini dibuat untuk menyelesaikan masalah antrean yang tidak teratur di kantin, dengan menerapkan prinsip antrean yang adil di mana mahasiswa yang datang lebih dulu akan dilayani lebih awal.

### Stack Teknologi & Algoritma

* **Bahasa Pemrograman:** Kotlin
* **Struktur Data utama:**
  `Queue` (Linear Queue diimplementasikan menggunakan `ArrayDeque`).
  * **Kompleksitas Waktu:** `O(1)` untuk operasi Enqueue (tambah antrean di belakang) dan Dequeue (layani antrean di depan).
* **Algoritma Pencarian:** `Searching` (Sequential / Linear Search).
  * **Kompleksitas Waktu:** `O(n)` karena program akan menelusuri data di dalam antrean satu per satu dari awal hingga akhir untuk menemukan nama pelanggan yang dicari.

---

## Struktur Proyek

Berikut adalah struktur folder dari repositori ini:

```text
.
├── README.md
├── Doc
│   ├── PPT
│   │   └── Projek Queue dan Searching - Kelompok 3 Struktur Data.pptx
│   └── Word
│       └── LAPORAN_UAS_KELOMPOK3_STRUKTUR_DATA.docx
└── Src
    ├── Queue
    |   ├── README.md
    │   ├── app
    │   │   └── queue.jar  
    │   └── src
    │       └── queue.kt
    └── Searching
        ├── README.md
        ├── Penjelasan_Source-Code.md
        ├── app
        │   └── searching.jar
        └── src
            └── searching.kt

```

### Penjelasan Detail Direktori:

1. **[Doc](https://github.com/WanZKey/UAS_STD_Kelompok-3/tree/main/Doc)**: Direktori ini berisi berkas dokumen non-kode pendukung proyek.

* `PPT`: Berisi berkas slide presentasi (`.pptx`) yang digunakan untuk demo aplikasi.
* `Word`: Berisi berkas laporan tertulis (`.docx`) mengenai permasalahan, penjelasan detail proyek, serta analisis cara kerja program dan kompleksitas algoritma.

2. **[Src](https://github.com/WanZKey/UAS_STD_Kelompok-3/tree/main/Src)**: Direktori ini berisi source code utama dari program beserta program yang sudah di-compile.

* **[Queue](https://www.google.com/search?q=https://github.com/WanZKey/UAS_STD_Kelompok-3/tree/main/Src/Queue)**: Berisi implementasi program utama manajemen antrean kantin. Terdapat source code Kotlin (`src/queue.kt`), file eksekusi Java Archive (`app/queue.jar`), dan panduan khusus program Queue (`README.md`).
* **[Searching](https://www.google.com/search?q=https://github.com/WanZKey/UAS_STD_Kelompok-3/tree/main/Src/Searching)**: Berisi implementasi program lanjutan dengan fitur pencarian pelanggan. Terdapat source code Kotlin (`src/searching.kt`), file eksekusi Java Archive (`app/searching.jar`), panduan khusus program Searching (`README.md`), dan file dokumentasi pembedahan kode (`Penjelasan_Source-Code.md`).

---

## Cara Menjalankan Program

Untuk menjalankan program ini di komputer lokal Anda, ikuti langkah-langkah berikut:

1. Buka Terminal atau Command Prompt.
2. Lakukan proses clone repositori ini ke dalam direktori komputer Anda dengan perintah berikut:

```text
git clone https://github.com/WanZKey/UAS_STD_Kelompok-3.git
```

3. Buka folder proyek tersebut di IDE Anda (seperti IntelliJ IDEA).
4. Navigasikan ke dalam folder `Src/Queue/src` atau `Src/Searching/src`, lalu jalankan file Kotlin berekstensi `.kt` yang tersedia di dalamnya.
5. Alternatifnya, Anda dapat langsung menjalankan file `.jar` yang berada di dalam folder `app` melalui terminal dengan perintah `java -jar namafile.jar` (pastikan JRE sudah terinstal).

**Berikut cara menjalankannya:**

```
java -jar queue.jar
```

atau

```
java -jar searching.jar
```

---
